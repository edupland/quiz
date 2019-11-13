package com.example.sully.quizwithserver.QuestionsActivities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.sully.quizwithserver.Manager;
import com.example.sully.quizwithserver.PlayfulActivities.*;
import com.example.sully.quizwithserver.R;

import java.util.HashMap;
import java.util.Map;

@SuppressLint("UseSparseArrays")
public class Q2Activity extends Manager {

    RadioGroup grp;
    Map<Integer, String> dict = new HashMap<>();

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_q2);

        grp = findViewById(R.id.radioGRP);

        dict.put(R.id.rep2_A, "H");
        dict.put(R.id.rep2_B, "F");
        dict.put(R.id.rep2_C, "Autre");
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

                if (isYoung) {
                    ((TextView) findViewById(R.id.quest2)).setText(getString(R.string.FRA_quest2_A));

                    ((TextView) findViewById(R.id.rep2_A)).setText(getString(R.string.FRA_rep2_AA));
                    ((TextView) findViewById(R.id.rep2_B)).setText(getString(R.string.FRA_rep2_AB));
                }else{
                    ((TextView) findViewById(R.id.quest2)).setText(getString(R.string.FRA_quest2_B));

                    ((TextView) findViewById(R.id.rep2_A)).setText(getString(R.string.FRA_rep2_BA));
                    ((TextView) findViewById(R.id.rep2_B)).setText(getString(R.string.FRA_rep2_BB));
                }

                ((TextView) findViewById(R.id.rep2_C)).setText(getString(R.string.FRA_rep2_C));

                break;

            case "ANG":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ANG_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ANG_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ANG_cancelText));

                if (isYoung) {
                    ((TextView) findViewById(R.id.quest2)).setText(getString(R.string.ANG_quest2_A));

                    ((TextView) findViewById(R.id.rep2_A)).setText(getString(R.string.ANG_rep2_AA));
                    ((TextView) findViewById(R.id.rep2_B)).setText(getString(R.string.ANG_rep2_AB));
                }else {
                    ((TextView) findViewById(R.id.quest2)).setText(getString(R.string.ANG_quest2_B));

                    ((TextView) findViewById(R.id.rep2_A)).setText(getString(R.string.ANG_rep2_BA));
                    ((TextView) findViewById(R.id.rep2_B)).setText(getString(R.string.ANG_rep2_BB));
                }

                ((TextView) findViewById(R.id.rep2_C)).setText(getString(R.string.ANG_rep2_C));
                break;
            case "ESP":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ESP_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ESP_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ESP_cancelText));

                if (isYoung) {
                    ((TextView) findViewById(R.id.quest2)).setText(getString(R.string.ESP_quest2_A));

                    ((TextView) findViewById(R.id.rep2_A)).setText(getString(R.string.ESP_rep2_AA));
                    ((TextView) findViewById(R.id.rep2_B)).setText(getString(R.string.ESP_rep2_AB));
                }else{
                    ((TextView) findViewById(R.id.quest2)).setText(getString(R.string.ESP_quest2_B));

                    ((TextView) findViewById(R.id.rep2_A)).setText(getString(R.string.ESP_rep2_BA));
                    ((TextView) findViewById(R.id.rep2_B)).setText(getString(R.string.ESP_rep2_BB));

                    ((TextView) findViewById(R.id.rep2_C)).setText(getString(R.string.ESP_rep2_C));
                    break;
                }

        }
    }

    public void previousView(View view) {
        timer.interrupt();

        data.remove(data.size()-1);

        changeView(Q1Activity.class);
    }

    public void nextView(View view) {
        timer.interrupt();

        data.add(dict.get(grp.getCheckedRadioButtonId()));

        changeView(P1Activity.class);
    }
}
