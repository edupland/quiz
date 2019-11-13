package com.example.sully.quizwithserver.PlayfulActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.sully.quizwithserver.Manager;
import com.example.sully.quizwithserver.QuestionsActivities.Q10Activity;
import com.example.sully.quizwithserver.QuestionsActivities.Q3Activity;
import com.example.sully.quizwithserver.R;

import java.util.ArrayList;

public class P5Activity extends Manager {

    private ArrayList<Integer> radioBoxesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p5);

        answersList = new ArrayList<>();

        radioBoxesList.add(R.id.rep_A);answersList.add(R.id.rep_A);
        radioBoxesList.add(R.id.rep_B);
        radioBoxesList.add(R.id.rep_C);
        radioBoxesList.add(R.id.rep_D);
    }

    @Override
    protected void onStart() {
        super.onStart();

        timer = setTimer();
        timer.start();

        switch (lang) {
            case "FRA":
                ((TextView) findViewById(R.id.bt_valid)).setText(getString(R.string.FRA_nextText));
                ((TextView) findViewById(R.id.bt_skip)).setText(getString(R.string.FRA_skipText));
                ((TextView) findViewById(R.id.bt_next)).setText(getString(R.string.FRA_nextText));

                ((TextView) findViewById(R.id.quest_PF)).setText(getString(R.string.FRA_questLud5));

                ((TextView) findViewById(R.id.rep_A)).setText(getString(R.string.FRA_repLud5_A));
                ((TextView) findViewById(R.id.rep_B)).setText(getString(R.string.FRA_repLud5_B));
                ((TextView) findViewById(R.id.rep_C)).setText(getString(R.string.FRA_repLud5_C));
                ((TextView) findViewById(R.id.rep_D)).setText(getString(R.string.FRA_repLud5_D));

                ((TextView) findViewById(R.id.descript_PF)).setText(getString(R.string.FRA_descriptLud5));

                break;

            case "ANG":
                ((TextView) findViewById(R.id.bt_valid)).setText(getString(R.string.ANG_nextText));
                ((TextView) findViewById(R.id.bt_skip)).setText(getString(R.string.ANG_skipText));
                ((TextView) findViewById(R.id.bt_next)).setText(getString(R.string.ANG_nextText));

                ((TextView) findViewById(R.id.quest_PF)).setText(getString(R.string.ANG_questLud5));

                ((TextView) findViewById(R.id.rep_A)).setText(getString(R.string.ANG_repLud5_A));
                ((TextView) findViewById(R.id.rep_B)).setText(getString(R.string.ANG_repLud5_B));
                ((TextView) findViewById(R.id.rep_C)).setText(getString(R.string.ANG_repLud5_C));
                ((TextView) findViewById(R.id.rep_D)).setText(getString(R.string.ANG_repLud5_D));

                ((TextView) findViewById(R.id.descript_PF)).setText(getString(R.string.ANG_descriptLud5));

                break;
            case "ESP":
                ((TextView) findViewById(R.id.bt_valid)).setText(getString(R.string.ESP_nextText));
                ((TextView) findViewById(R.id.bt_skip)).setText(getString(R.string.ESP_skipText));
                ((TextView) findViewById(R.id.bt_next)).setText(getString(R.string.ESP_nextText));

                ((TextView) findViewById(R.id.quest_PF)).setText(getString(R.string.ESP_questLud5));

                ((TextView) findViewById(R.id.rep_A)).setText(getString(R.string.ESP_repLud5_A));
                ((TextView) findViewById(R.id.rep_B)).setText(getString(R.string.ESP_repLud5_B));
                ((TextView) findViewById(R.id.rep_C)).setText(getString(R.string.ESP_repLud5_C));
                ((TextView) findViewById(R.id.rep_D)).setText(getString(R.string.ESP_repLud5_D));

                ((TextView) findViewById(R.id.descript_PF)).setText(getString(R.string.ESP_descriptLud5));

                break;
        }
    }

    public void verifAnswer(){

        if(goodAnswer(radioBoxesList)){
            ((TextView)findViewById(answersList.get(0))).setTextColor(COLOR_GREEN);

            findViewById(R.id.layoutA).setVisibility(View.VISIBLE);
            findViewById(R.id.descript_PF).setVisibility(View.VISIBLE);

            findViewById(R.id.layoutB).setVisibility(View.GONE);
            (findViewById(R.id.rep_A)).setEnabled(false);
            findViewById(R.id.rep_B).setVisibility(View.GONE);
            findViewById(R.id.rep_C).setVisibility(View.GONE);
            findViewById(R.id.rep_D).setVisibility(View.GONE);
        }
    }

    public void nextView(View view) {
        timer.interrupt();

        changeView(Q10Activity.class);
    }

    public void validationView(View view) {
        rerun(null);

        verifAnswer();

    }
}
