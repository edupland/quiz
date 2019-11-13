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
public class Q6Activity extends Manager {

    RadioGroup grp;
    Map<Integer, String> dict = new HashMap<>();

    @Override
    protected  void onCreate(Bundle bundle){
        super.onCreate(bundle);

        setContentView(R.layout.activity_q6);

        grp = findViewById(R.id.radioGRP);

        dict.put(R.id.rep6_A, "Famille");
        dict.put(R.id.rep6_B, "Amis");
        dict.put(R.id.rep6_C, "Professionels");
        dict.put(R.id.rep6_D, "Scolaire");
        dict.put(R.id.rep6_E, "Autres");

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

                ((TextView) findViewById(R.id.quest6)).setText(getString(R.string.FRA_quest6));

                ((TextView) findViewById(R.id.rep6_A)).setText(getString(R.string.FRA_rep6_A));
                ((TextView) findViewById(R.id.rep6_B)).setText(getString(R.string.FRA_rep6_B));
                ((TextView) findViewById(R.id.rep6_C)).setText(getString(R.string.FRA_rep6_C));
                ((TextView) findViewById(R.id.rep6_D)).setText(getString(R.string.FRA_rep6_D));
                ((TextView) findViewById(R.id.rep6_E)).setText(getString(R.string.FRA_rep6_E));
                break;

            case "ANG":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ANG_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ANG_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ANG_cancelText));

                ((TextView) findViewById(R.id.quest6)).setText(getString(R.string.ANG_quest6));

                ((TextView) findViewById(R.id.rep6_A)).setText(getString(R.string.ANG_rep6_A));
                ((TextView) findViewById(R.id.rep6_B)).setText(getString(R.string.ANG_rep6_B));
                ((TextView) findViewById(R.id.rep6_C)).setText(getString(R.string.ANG_rep6_C));
                ((TextView) findViewById(R.id.rep6_D)).setText(getString(R.string.ANG_rep6_D));
                ((TextView) findViewById(R.id.rep6_E)).setText(getString(R.string.ANG_rep6_E));
                break;
            case "ESP":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ESP_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ESP_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ESP_cancelText));

                ((TextView) findViewById(R.id.quest6)).setText(getString(R.string.ESP_quest6));

                ((TextView) findViewById(R.id.rep6_A)).setText(getString(R.string.ESP_rep6_A));
                ((TextView) findViewById(R.id.rep6_B)).setText(getString(R.string.ESP_rep6_B));
                ((TextView) findViewById(R.id.rep6_C)).setText(getString(R.string.ESP_rep6_C));
                ((TextView) findViewById(R.id.rep6_D)).setText(getString(R.string.ESP_rep6_D));
                ((TextView) findViewById(R.id.rep6_E)).setText(getString(R.string.ESP_rep6_E));
                break;
        }

    }

    public void previousView(View view) {
        timer.interrupt();
        data.remove(data.size()-1);

        changeView(Q12Activity.class);
    }

    public void nextView(View view) {
        timer.interrupt();

        data.add(dict.get(grp.getCheckedRadioButtonId()));

        changeView(Q7Activity.class);
    }
}
