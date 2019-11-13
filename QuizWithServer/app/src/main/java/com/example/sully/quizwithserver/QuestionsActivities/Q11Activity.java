package com.example.sully.quizwithserver.QuestionsActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sully.quizwithserver.DatabaseFiles.VolleySingleton;
import com.example.sully.quizwithserver.LastActivity;
import com.example.sully.quizwithserver.Manager;
import com.example.sully.quizwithserver.R;
import com.example.sully.quizwithserver.Requests.MyRequest;

public class Q11Activity extends Manager {


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_q11);
    }

    @Override
    protected void onStart() {
        super.onStart();

        timer = setTimer();
        timer.start();

        switch (lang) {
            case "FRA":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.FRA_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.FRA_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.FRA_cancelText));

                ((TextView) findViewById(R.id.quest11)).setText(getString(R.string.FRA_quest11));
                ((EditText)findViewById(R.id.editText)).setText(getString(R.string.FRA_rep11));
                break;

            case "ANG":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ANG_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ANG_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ANG_cancelText));

                ((TextView) findViewById(R.id.quest11)).setText(getString(R.string.ANG_quest11));
                ((EditText)findViewById(R.id.editText)).setText(getString(R.string.ANG_rep11));
                break;
            case "ESP":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ESP_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ESP_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ESP_cancelText));

                ((TextView) findViewById(R.id.quest11)).setText(getString(R.string.ESP_quest11));
                ((EditText)findViewById(R.id.editText)).setText(getString(R.string.ESP_rep11));
                break;
        }

        queue = VolleySingleton.getInstance(this).getRequestQueue();
        request = new MyRequest(this, queue);

        ((EditText)findViewById(R.id.editText)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged (CharSequence s,int start, int count,int after){
                timer.interrupt();
            }

            @Override
            public void onTextChanged ( final CharSequence s, int start, int before, int count){
            }

            @Override
            public void afterTextChanged ( final Editable s){
                timer = setTimer();
                timer.start();
            }
        });

    }

    public void previousView(View view) {
        timer.interrupt();
        data.remove(data.size()-1);

        changeView(Q10Activity.class);
    }

    public void nextView(View view) {
        timer.interrupt();

        String com = ((EditText)findViewById(R.id.editText)).getText().toString();
        if(     com.length() < 1 ||
                (com.equals(getString(R.string.FRA_rep11)) && lang.equals("FRA"))||
                (com.equals(getString(R.string.ANG_rep11)) && lang.equals("ANG"))||
                (com.equals(getString(R.string.ESP_rep11)) && lang.equals("ESP"))){
            data.add("Sans commentaire");
        }else{
            data.add(com);
        }

        sendToDatabase();

        changeView(LastActivity.class);
    }
}
