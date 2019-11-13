package com.example.sully.quizwithserver;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.example.sully.quizwithserver.Requests.MyRequest;
import java.util.ArrayList;

public abstract class Manager extends AppCompatActivity{

    public static ArrayList<Object> data = new ArrayList<>();
    protected ArrayList<Integer> answersList;

    protected static boolean isYoung = false;
    protected static String lang;

    protected static int COLOR_RED = Color.rgb(247, 35, 12);
    protected static int COLOR_GREEN = Color.rgb(127, 221, 76);
    protected static int COLOR_NEUTRAL = Color.rgb(0, 0, 0);

    protected RequestQueue queue;
    protected MyRequest request;

    protected Thread timer = null;
    protected static int sleepUser = 60000;

    final protected Thread setTimer() {

        if(timer != null && !timer.isInterrupted())
            timer.interrupt();
        return new Thread() {

            public void run() {
                try {
                    sleep(sleepUser);
                    mainView(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

    }

    final protected Thread setTimer(final int nb_millisec) {

        if(timer != null && !timer.isInterrupted())
            timer.interrupt();
        return new Thread() {

            public void run() {
                try {
                    sleep(nb_millisec);
                    mainView(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

    }

    public void rerun(View v){
        timer.interrupt();
        timer = setTimer();
        timer.start();
    }

    final public void mainView(View view) {
        data = new ArrayList<>();

        timer.interrupt();
        timer = null;

        ActivityCompat.finishAffinity(this);

        Intent intent= new Intent(this, FirstActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);

    }

    public ArrayList<Integer> treatmentCheckboxes(ArrayList<Integer> list){

        ArrayList<Integer> checkBoxesChecked = new ArrayList<>();
        for(int l : list){
            if(((CheckBox)findViewById(l)).isChecked()){
                checkBoxesChecked.add(l);
            }
        }

        return checkBoxesChecked;
    }

    public boolean goodAnswer(ArrayList<Integer> l){

        boolean verif = false;
        int real_answer = answersList.get(0);

        for (int user : l) {
            if ( ((RadioButton)findViewById(user)).isChecked() && real_answer == user) {
                ((TextView) findViewById(real_answer)).setTextColor(COLOR_GREEN);
                verif = true;
            } else if( ((RadioButton)findViewById(user)).isChecked() && ((TextView) findViewById(user)).getCurrentTextColor()!= COLOR_GREEN){
                ((TextView) findViewById(user)).setTextColor(COLOR_RED);
            } else if(  !((RadioButton)findViewById(user)).isChecked() ) {
                ((TextView) findViewById(user)).setTextColor(COLOR_NEUTRAL);
            }
        }
        return verif;
    }


    public void sendToDatabase(){
        request.insert(data);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(timer != null) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                rerun(null);
            }
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                timer.interrupt();
            }
            if (event.getAction() == MotionEvent.ACTION_UP ) {
                rerun(null);
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);

        onStart();

    }

    protected int getSize(){
        return data.size();
    }


    public void changeView(Class<?> cls){
        Intent intent= new Intent(getApplicationContext(), cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivityIfNeeded(intent, 0);
    }
}
