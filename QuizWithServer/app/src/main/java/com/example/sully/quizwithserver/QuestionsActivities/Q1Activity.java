package com.example.sully.quizwithserver.QuestionsActivities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sully.quizwithserver.Manager;
import com.example.sully.quizwithserver.R;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint("UseSparseArrays")
public class Q1Activity extends Manager {

    RadioGroup grp = null;
    Map<Integer, String> dict = new HashMap<>();

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_q1);

        grp = findViewById(R.id.radioGRP);

        dict.put(R.id.rep1_A,"-15");
        dict.put(R.id.rep1_B,"16-25");
        dict.put(R.id.rep1_C,"26-45");
        dict.put(R.id.rep1_D,"46-60");
        dict.put(R.id.rep1_E,"+60");
        dict.put(R.id.rep1_F,"Autre");
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

                ((TextView) findViewById(R.id.quest1)).setText(getString(R.string.FRA_quest1));

                ((TextView) findViewById(R.id.rep1_A)).setText(getString(R.string.FRA_rep1_A));
                ((TextView) findViewById(R.id.rep1_B)).setText(getString(R.string.FRA_rep1_B));
                ((TextView) findViewById(R.id.rep1_C)).setText(getString(R.string.FRA_rep1_C));
                ((TextView) findViewById(R.id.rep1_D)).setText(getString(R.string.FRA_rep1_D));
                ((TextView) findViewById(R.id.rep1_E)).setText(getString(R.string.FRA_rep1_E));

                ((TextView) findViewById(R.id.rep1_F)).setText(getString(R.string.FRA_rep1_F));
                break;

            case "ANG":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ANG_nextText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ANG_cancelText));

                ((TextView) findViewById(R.id.quest1)).setText(getString(R.string.ANG_quest1));

                ((TextView) findViewById(R.id.rep1_A)).setText(getString(R.string.ANG_rep1_A));
                ((TextView) findViewById(R.id.rep1_B)).setText(getString(R.string.ANG_rep1_B));
                ((TextView) findViewById(R.id.rep1_C)).setText(getString(R.string.ANG_rep1_C));
                ((TextView) findViewById(R.id.rep1_D)).setText(getString(R.string.ANG_rep1_D));
                ((TextView) findViewById(R.id.rep1_E)).setText(getString(R.string.ANG_rep1_E));

                ((TextView) findViewById(R.id.rep1_F)).setText(getString(R.string.ANG_rep1_F));
                break;
            case "ESP":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ESP_nextText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ESP_cancelText));

                ((TextView) findViewById(R.id.quest1)).setText(getString(R.string.ESP_quest1));

                ((TextView) findViewById(R.id.rep1_A)).setText(getString(R.string.ESP_rep1_A));
                ((TextView) findViewById(R.id.rep1_B)).setText(getString(R.string.ESP_rep1_B));
                ((TextView) findViewById(R.id.rep1_C)).setText(getString(R.string.ESP_rep1_C));
                ((TextView) findViewById(R.id.rep1_D)).setText(getString(R.string.ESP_rep1_D));
                ((TextView) findViewById(R.id.rep1_E)).setText(getString(R.string.ESP_rep1_E));

                ((TextView) findViewById(R.id.rep1_F)).setText(getString(R.string.ESP_rep1_F));
                break;
        }
    }

    public void nextView(View view) {
        timer.interrupt();

        data.add(dict.get(grp.getCheckedRadioButtonId()));
        isYoung = grp.getCheckedRadioButtonId() == R.id.rep1_A;

        changeView(Q2Activity.class);
    }
    
}
