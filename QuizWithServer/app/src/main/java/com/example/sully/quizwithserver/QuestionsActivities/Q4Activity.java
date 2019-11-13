package com.example.sully.quizwithserver.QuestionsActivities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.sully.quizwithserver.Manager;
import com.example.sully.quizwithserver.PlayfulActivities.P2Activity;
import com.example.sully.quizwithserver.R;
import java.util.HashMap;
import java.util.Map;

@SuppressLint("UseSparseArrays")
public class Q4Activity extends Manager {

    RadioGroup grp;
    Map<Integer, String> dict = new HashMap<>();

    @Override
    protected  void onCreate(Bundle bundle){
        super.onCreate(bundle);

        setContentView(R.layout.activity_q4);

        grp = findViewById(R.id.radioGRP);

        dict.put(R.id.rep4_A, getString(R.string.FRA_rep4_A));
        dict.put(R.id.rep4_B, getString(R.string.FRA_rep4_B));
        dict.put(R.id.rep4_C, getString(R.string.FRA_rep4_C));
        dict.put(R.id.rep4_D, getString(R.string.FRA_rep4_D));
        dict.put(R.id.rep4_F, getString(R.string.FRA_rep4_F));
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
                    ((TextView) findViewById(R.id.quest4)).setText(getString(R.string.FRA_quest4_A));
                }else {
                    ((TextView) findViewById(R.id.quest4)).setText(getString(R.string.FRA_quest4_B));
                }

                ((TextView) findViewById(R.id.rep4_A)).setText(getString(R.string.FRA_rep4_A));
                ((TextView) findViewById(R.id.rep4_B)).setText(getString(R.string.FRA_rep4_B));
                ((TextView) findViewById(R.id.rep4_C)).setText(getString(R.string.FRA_rep4_C));
                ((TextView) findViewById(R.id.rep4_D)).setText(getString(R.string.FRA_rep4_D));
                ((TextView) findViewById(R.id.rep4_F)).setText(getString(R.string.FRA_rep4_F));
                break;

            case "ANG":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ANG_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ANG_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ANG_cancelText));

                if (isYoung) {
                    ((TextView) findViewById(R.id.quest4)).setText(getString(R.string.ANG_quest4_A));
                }else {
                    ((TextView) findViewById(R.id.quest4)).setText(getString(R.string.ANG_quest4_B));
                }

                ((TextView) findViewById(R.id.rep4_A)).setText(getString(R.string.ANG_rep4_A));
                ((TextView) findViewById(R.id.rep4_B)).setText(getString(R.string.ANG_rep4_B));
                ((TextView) findViewById(R.id.rep4_C)).setText(getString(R.string.ANG_rep4_C));
                ((TextView) findViewById(R.id.rep4_D)).setText(getString(R.string.ANG_rep4_D));
                ((TextView) findViewById(R.id.rep4_F)).setText(getString(R.string.ANG_rep4_F));
                break;
            case "ESP":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ESP_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ESP_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ESP_cancelText));

                if (isYoung) {
                    ((TextView) findViewById(R.id.quest4)).setText(getString(R.string.ESP_quest4_A));
                }else {
                    ((TextView) findViewById(R.id.quest4)).setText(getString(R.string.ESP_quest4_B));
                }

                ((TextView) findViewById(R.id.rep4_A)).setText(getString(R.string.ESP_rep4_A));
                ((TextView) findViewById(R.id.rep4_B)).setText(getString(R.string.ESP_rep4_B));
                ((TextView) findViewById(R.id.rep4_C)).setText(getString(R.string.ESP_rep4_C));
                ((TextView) findViewById(R.id.rep4_D)).setText(getString(R.string.ESP_rep4_D));
                ((TextView) findViewById(R.id.rep4_F)).setText(getString(R.string.ESP_rep4_F));
                break;
        }
    }

    public void previousView(View view) {
        timer.interrupt();

        data.remove(data.size()-1);

        changeView(Q3Activity.class);
    }

    public void nextView(View view) {
        timer.interrupt();

        data.add(dict.get(grp.getCheckedRadioButtonId()));

        changeView(P2Activity.class);
    }
}
