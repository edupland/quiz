package com.example.sully.quizwithserver.QuestionsActivities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.sully.quizwithserver.Manager;
import com.example.sully.quizwithserver.R;
import java.util.HashMap;
import java.util.Map;

@SuppressLint("UseSparseArrays")
public class Q5Activity extends Manager {

    RadioGroup grp;
    Map<Integer, String> dict = new HashMap<>();

    @Override
    protected  void onCreate(Bundle bundle){
        super.onCreate(bundle);

        setContentView(R.layout.activity_q5);

        grp = findViewById(R.id.radioGRP);

        dict.put(R.id.rep5_A, getString(R.string.FRA_rep5_A));
        dict.put(R.id.rep5_B, getString(R.string.FRA_rep5_B));
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

                ((TextView) findViewById(R.id.quest5)).setText(getString(R.string.FRA_quest5));

                ((TextView) findViewById(R.id.rep5_A)).setText(getString(R.string.FRA_rep5_A));
                ((TextView) findViewById(R.id.rep5_B)).setText(getString(R.string.FRA_rep5_B));
                break;

            case "ANG":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ANG_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ANG_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ANG_cancelText));

                ((TextView) findViewById(R.id.quest5)).setText(getString(R.string.ANG_quest5));

                ((TextView) findViewById(R.id.rep5_A)).setText(getString(R.string.ANG_rep5_A));
                ((TextView) findViewById(R.id.rep5_B)).setText(getString(R.string.ANG_rep5_B));
                break;
            case "ESP":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ESP_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ESP_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ESP_cancelText));

                ((TextView) findViewById(R.id.quest5)).setText(getString(R.string.ESP_quest5));

                ((TextView) findViewById(R.id.rep5_A)).setText(getString(R.string.ESP_rep5_A));
                ((TextView) findViewById(R.id.rep5_B)).setText(getString(R.string.ESP_rep5_B));
                break;
        }

    }

    public void previousView(View view) {
        timer.interrupt();

        data.remove(data.size()-1);

        changeView(Q4Activity.class);
    }

    public void nextView(View view) {
        timer.interrupt();

        data.add(dict.get(grp.getCheckedRadioButtonId()));

        changeView(Q12Activity.class);
    }
}
