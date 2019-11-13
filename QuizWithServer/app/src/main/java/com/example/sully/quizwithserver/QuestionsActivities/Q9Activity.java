package com.example.sully.quizwithserver.QuestionsActivities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.sully.quizwithserver.Manager;
import com.example.sully.quizwithserver.PlayfulActivities.P5Activity;
import com.example.sully.quizwithserver.R;
import java.util.HashMap;
import java.util.Map;

@SuppressLint("UseSparseArrays")
public class Q9Activity extends Manager {

    RadioGroup grp;
    Map<Integer, String> dict = new HashMap<>();

    @Override
    protected  void onCreate(Bundle bundle){
        super.onCreate(bundle);

        setContentView(R.layout.activity_q9);

        grp = findViewById(R.id.radioGRP);

        dict.put(R.id.rep9_A, getString(R.string.FRA_rep9_A));
        dict.put(R.id.rep9_B, getString(R.string.FRA_rep9_B));
        dict.put(R.id.rep9_C, getString(R.string.FRA_rep9_C));
        dict.put(R.id.rep9_D, getString(R.string.FRA_rep9_D));

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

                ((TextView) findViewById(R.id.quest9)).setText(getString(R.string.FRA_quest9));

                ((TextView) findViewById(R.id.rep9_A)).setText(getString(R.string.FRA_rep9_A));
                ((TextView) findViewById(R.id.rep9_B)).setText(getString(R.string.FRA_rep9_B));
                ((TextView) findViewById(R.id.rep9_C)).setText(getString(R.string.FRA_rep9_C));
                ((TextView) findViewById(R.id.rep9_D)).setText(getString(R.string.FRA_rep9_D));

                break;

            case "ANG":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ANG_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ANG_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ANG_cancelText));

                ((TextView) findViewById(R.id.quest9)).setText(getString(R.string.ANG_quest9));

                ((TextView) findViewById(R.id.rep9_A)).setText(getString(R.string.ANG_rep9_A));
                ((TextView) findViewById(R.id.rep9_B)).setText(getString(R.string.ANG_rep9_B));
                ((TextView) findViewById(R.id.rep9_C)).setText(getString(R.string.ANG_rep9_C));
                ((TextView) findViewById(R.id.rep9_D)).setText(getString(R.string.ANG_rep9_D));
                break;
            case "ESP":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ESP_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ESP_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ESP_cancelText));

                ((TextView) findViewById(R.id.quest9)).setText(getString(R.string.ESP_quest9));

                ((TextView) findViewById(R.id.rep9_A)).setText(getString(R.string.ESP_rep9_A));
                ((TextView) findViewById(R.id.rep9_B)).setText(getString(R.string.ESP_rep9_B));
                ((TextView) findViewById(R.id.rep9_C)).setText(getString(R.string.ESP_rep9_C));
                ((TextView) findViewById(R.id.rep9_D)).setText(getString(R.string.ESP_rep9_D));
                break;
        }
    }

    public void previousView(View view) {
        data.remove(data.size()-1);

        timer.interrupt();

        changeView(Q8Activity.class);
    }

    public void nextView(View view) {
        data.add(dict.get(grp.getCheckedRadioButtonId()));

        timer.interrupt();

        changeView(P5Activity.class);
    }
}
