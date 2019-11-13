package com.example.sully.quizwithserver.PlayfulActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sully.quizwithserver.Manager;
import com.example.sully.quizwithserver.QuestionsActivities.Q11Activity;
import com.example.sully.quizwithserver.R;

import java.util.ArrayList;

public class P6Activity extends Manager {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p6);

        answersList = new ArrayList<>();
        answersList.add(R.id.img_PF_A);

    }

    @Override
    protected void onStart(){
        super.onStart();

        timer = setTimer();
        timer.start();

        switch (lang) {
            case "FRA":

                ((Button) findViewById(R.id.bt_valid)).setText(getString(R.string.FRA_nextText));
                ((Button) findViewById(R.id.bt_skip)).setText(getString(R.string.FRA_skipText));
                ((Button) findViewById(R.id.bt_next)).setText(getString(R.string.FRA_nextText));

                ((TextView) findViewById(R.id.quest_PF)).setText(getString(R.string.FRA_questLud6));

                ((TextView) findViewById(R.id.descript_PF)).setText(getString(R.string.FRA_descriptLud6));

                break;

            case "ANG":

                ((Button) findViewById(R.id.bt_valid)).setText(getString(R.string.ANG_nextText));
                ((Button) findViewById(R.id.bt_skip)).setText(getString(R.string.ANG_skipText));
                ((Button) findViewById(R.id.bt_next)).setText(getString(R.string.ANG_nextText));

                ((TextView) findViewById(R.id.quest_PF)).setText(getString(R.string.ANG_questLud6));

                ((TextView) findViewById(R.id.descript_PF)).setText(getString(R.string.ANG_descriptLud6));

                break;
            case "ESP":

                ((Button) findViewById(R.id.bt_valid)).setText(getString(R.string.ESP_nextText));
                ((Button) findViewById(R.id.bt_skip)).setText(getString(R.string.ESP_skipText));
                ((Button) findViewById(R.id.bt_next)).setText(getString(R.string.ESP_nextText));

                ((TextView) findViewById(R.id.quest_PF)).setText(getString(R.string.ESP_questLud6));

                ((TextView) findViewById(R.id.descript_PF)).setText(getString(R.string.ESP_descriptLud6));

                break;
        }
    }

    public boolean verifAnswer(){

        if( (findViewById(answersList.get(0))).getBackground() != null){
            (findViewById(answersList.get(0))).setBackground(getResources().getDrawable(R.drawable.hightlight_good));
            return true;
        }else{
            (findViewById(R.id.img_PF_B)).setBackground(getResources().getDrawable(R.drawable.hightlight_bad));
            return false;
        }

    }

    public void choice_hightlight(View v){

        rerun(null);

        if(v.getBackground() == null){
            v.setBackground(getResources().getDrawable(R.drawable.hightlight));
            if(v != findViewById(R.id.img_PF_A))
                findViewById(R.id.img_PF_A).setBackground(null);
            else
                findViewById(R.id.img_PF_B).setBackground(null);
        }
    }

    public void nextView(View view) {
        timer.interrupt();

        changeView(Q11Activity.class);
    }

    public void validationView(View view) {
        rerun(null);

        if(verifAnswer()) {
            (findViewById(R.id.img_PF_B)).setVisibility(View.GONE);
            (findViewById(R.id.descript_PF)).setVisibility(View.VISIBLE);

            (findViewById(R.id.layoutA)).setVisibility(View.VISIBLE);
            (findViewById(R.id.layoutB)).setVisibility(View.GONE);

        }

    }
}
