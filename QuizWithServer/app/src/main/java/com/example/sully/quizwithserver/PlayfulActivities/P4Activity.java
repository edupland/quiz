package com.example.sully.quizwithserver.PlayfulActivities;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.sully.quizwithserver.Manager;
import com.example.sully.quizwithserver.QuestionsActivities.Q3Activity;
import com.example.sully.quizwithserver.QuestionsActivities.Q8Activity;
import com.example.sully.quizwithserver.R;

import java.util.ArrayList;
import java.util.List;

public class P4Activity extends Manager {

    private ArrayList<Integer> checkboxesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4);

        answersList = new ArrayList<>();

        checkboxesList.add(R.id.rep_A);answersList.add(R.id.rep_A);
        checkboxesList.add(R.id.rep_B);
        checkboxesList.add(R.id.rep_C);
        checkboxesList.add(R.id.rep_D);
        checkboxesList.add(R.id.rep_E);answersList.add(R.id.rep_E);
        checkboxesList.add(R.id.rep_F);
        checkboxesList.add(R.id.rep_G);
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

                ((TextView) findViewById(R.id.quest_PF)).setText(getString(R.string.FRA_questLud4));

                ((TextView) findViewById(R.id.rep_A)).setText(getString(R.string.FRA_repLud4_A));
                ((TextView) findViewById(R.id.rep_B)).setText(getString(R.string.FRA_repLud4_B));
                ((TextView) findViewById(R.id.rep_C)).setText(getString(R.string.FRA_repLud4_C));
                ((TextView) findViewById(R.id.rep_D)).setText(getString(R.string.FRA_repLud4_D));
                ((TextView) findViewById(R.id.rep_E)).setText(getString(R.string.FRA_repLud4_E));
                ((TextView) findViewById(R.id.rep_F)).setText(getString(R.string.FRA_repLud4_F));
                ((TextView) findViewById(R.id.rep_G)).setText(getString(R.string.FRA_repLud4_G));

                ((TextView) findViewById(R.id.descript_PF)).setText(getString(R.string.FRA_descriptLud4));

                break;

            case "ANG":
                ((TextView) findViewById(R.id.bt_valid)).setText(getString(R.string.ANG_nextText));
                ((TextView) findViewById(R.id.bt_skip)).setText(getString(R.string.ANG_skipText));
                ((TextView) findViewById(R.id.bt_next)).setText(getString(R.string.ANG_nextText));

                ((TextView) findViewById(R.id.quest_PF)).setText(getString(R.string.ANG_questLud4));

                ((TextView) findViewById(R.id.rep_A)).setText(getString(R.string.ANG_repLud4_A));
                ((TextView) findViewById(R.id.rep_B)).setText(getString(R.string.ANG_repLud4_B));
                ((TextView) findViewById(R.id.rep_C)).setText(getString(R.string.ANG_repLud4_C));
                ((TextView) findViewById(R.id.rep_D)).setText(getString(R.string.ANG_repLud4_D));
                ((TextView) findViewById(R.id.rep_E)).setText(getString(R.string.ANG_repLud4_E));
                ((TextView) findViewById(R.id.rep_F)).setText(getString(R.string.ANG_repLud4_F));
                ((TextView) findViewById(R.id.rep_G)).setText(getString(R.string.ANG_repLud4_G));

                ((TextView) findViewById(R.id.descript_PF)).setText(getString(R.string.ANG_descriptLud4));

                break;
            case "ESP":
                ((TextView) findViewById(R.id.bt_valid)).setText(getString(R.string.ESP_nextText));
                ((TextView) findViewById(R.id.bt_skip)).setText(getString(R.string.ESP_skipText));
                ((TextView) findViewById(R.id.bt_next)).setText(getString(R.string.ESP_nextText));

                ((TextView) findViewById(R.id.quest_PF)).setText(getString(R.string.ESP_questLud4));

                ((TextView) findViewById(R.id.rep_A)).setText(getString(R.string.ESP_repLud4_A));
                ((TextView) findViewById(R.id.rep_B)).setText(getString(R.string.ESP_repLud4_B));
                ((TextView) findViewById(R.id.rep_C)).setText(getString(R.string.ESP_repLud4_C));
                ((TextView) findViewById(R.id.rep_D)).setText(getString(R.string.ESP_repLud4_D));
                ((TextView) findViewById(R.id.rep_E)).setText(getString(R.string.ESP_repLud4_E));
                ((TextView) findViewById(R.id.rep_F)).setText(getString(R.string.ESP_repLud4_F));
                ((TextView) findViewById(R.id.rep_G)).setText(getString(R.string.ESP_repLud4_G));

                ((TextView) findViewById(R.id.descript_PF)).setText(getString(R.string.ESP_descriptLud4));

                break;
        }
    }

    @Override
    public boolean goodAnswer(ArrayList<Integer> l) {

        int verif = 0;

        for (int real_answer : answersList) {
            for (int user : l) {
                if (((CheckBox) findViewById(user)).isChecked() && real_answer == user) {
                    ((TextView) findViewById(real_answer)).setTextColor(COLOR_GREEN);
                    verif++;
                } else if (((CheckBox) findViewById(user)).isChecked() && ((TextView) findViewById(user)).getCurrentTextColor() != COLOR_GREEN) {
                    ((TextView) findViewById(user)).setTextColor(COLOR_RED);
                } else if (!((CheckBox) findViewById(user)).isChecked()) {
                    ((TextView) findViewById(user)).setTextColor(COLOR_NEUTRAL);
                }
            }
        }
        return verif == answersList.size();
    }

    public void verifAnswer(){

        if(goodAnswer(checkboxesList)){

            findViewById(R.id.layoutA).setVisibility(View.VISIBLE);
            findViewById(R.id.descript_PF).setVisibility(View.VISIBLE);

            findViewById(R.id.layoutB).setVisibility(View.GONE);

            (findViewById(R.id.rep_A)).setEnabled(false);
            findViewById(R.id.rep_B).setVisibility(View.GONE);
            findViewById(R.id.rep_C).setVisibility(View.GONE);
            findViewById(R.id.rep_D).setVisibility(View.GONE);
            (findViewById(R.id.rep_E)).setEnabled(false);
            findViewById(R.id.rep_F).setVisibility(View.GONE);
            findViewById(R.id.rep_G).setVisibility(View.GONE);
        }

    }

    public void nextView(View view) {
        timer.interrupt();

        changeView(Q8Activity.class);
    }

    public void validationView(View view) {
        rerun(null);

        verifAnswer();

    }
}
