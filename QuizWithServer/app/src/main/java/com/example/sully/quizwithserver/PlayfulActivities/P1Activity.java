package com.example.sully.quizwithserver.PlayfulActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.sully.quizwithserver.Manager;
import com.example.sully.quizwithserver.QuestionsActivities.Q3Activity;
import com.example.sully.quizwithserver.R;

import java.util.ArrayList;

public class P1Activity extends Manager {

    private ArrayList<Integer> radioBoxesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1);

        answersList = new ArrayList<>();

        radioBoxesList.add(R.id.rep_A);
        radioBoxesList.add(R.id.rep_B);answersList.add(R.id.rep_B);
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

                ((TextView) findViewById(R.id.quest_PF)).setText(getString(R.string.FRA_questLud1));

                ((TextView) findViewById(R.id.rep_A)).setText(getString(R.string.FRA_repLud1_A));
                ((TextView) findViewById(R.id.rep_B)).setText(getString(R.string.FRA_repLud1_B));
                ((TextView) findViewById(R.id.rep_C)).setText(getString(R.string.FRA_repLud1_C));
                ((TextView) findViewById(R.id.rep_D)).setText(getString(R.string.FRA_repLud1_D));

                ((TextView) findViewById(R.id.descript_PF)).setText(getString(R.string.FRA_descriptLud1));

                break;

            case "ANG":
                ((TextView) findViewById(R.id.bt_valid)).setText(getString(R.string.ANG_nextText));
                ((TextView) findViewById(R.id.bt_skip)).setText(getString(R.string.ANG_skipText));
                ((TextView) findViewById(R.id.bt_next)).setText(getString(R.string.ANG_nextText));

                ((TextView) findViewById(R.id.quest_PF)).setText(getString(R.string.ANG_questLud1));

                ((TextView) findViewById(R.id.rep_A)).setText(getString(R.string.ANG_repLud1_A));
                ((TextView) findViewById(R.id.rep_B)).setText(getString(R.string.ANG_repLud1_B));
                ((TextView) findViewById(R.id.rep_C)).setText(getString(R.string.ANG_repLud1_C));
                ((TextView) findViewById(R.id.rep_D)).setText(getString(R.string.ANG_repLud1_D));

                ((TextView) findViewById(R.id.descript_PF)).setText(getString(R.string.ANG_descriptLud1));

                break;
            case "ESP":
                ((TextView) findViewById(R.id.bt_valid)).setText(getString(R.string.ESP_nextText));
                ((TextView) findViewById(R.id.bt_skip)).setText(getString(R.string.ESP_skipText));
                ((TextView) findViewById(R.id.bt_next)).setText(getString(R.string.ESP_nextText));

                ((TextView) findViewById(R.id.quest_PF)).setText(getString(R.string.ESP_questLud1));

                ((TextView) findViewById(R.id.rep_A)).setText(getString(R.string.FRA_repLud1_A));
                ((TextView) findViewById(R.id.rep_B)).setText(getString(R.string.ESP_repLud1_B));
                ((TextView) findViewById(R.id.rep_C)).setText(getString(R.string.ESP_repLud1_C));
                ((TextView) findViewById(R.id.rep_D)).setText(getString(R.string.ESP_repLud1_D));

                ((TextView) findViewById(R.id.descript_PF)).setText(getString(R.string.ESP_descriptLud1));

                break;
        }
    }


    public void verifAnswer(){

        if(goodAnswer(radioBoxesList)){
            ((TextView)findViewById(answersList.get(0))).setTextColor(COLOR_GREEN);

            findViewById(R.id.layoutA).setVisibility(View.VISIBLE);
            findViewById(R.id.descript_PF).setVisibility(View.VISIBLE);

            findViewById(R.id.layoutB).setVisibility(View.GONE);
            findViewById(R.id.rep_A).setVisibility(View.GONE);
            (findViewById(R.id.rep_B)).setEnabled(false);
            findViewById(R.id.rep_C).setVisibility(View.GONE);
            findViewById(R.id.rep_D).setVisibility(View.GONE);
        }
    }

    public void nextView(View view) {
        timer.interrupt();

        changeView(Q3Activity.class);
    }

    public void validationView(View view) {
        rerun(null);

        verifAnswer();

    }
}
