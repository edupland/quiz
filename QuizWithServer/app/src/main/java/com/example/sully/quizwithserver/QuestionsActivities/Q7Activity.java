package com.example.sully.quizwithserver.QuestionsActivities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.sully.quizwithserver.Manager;
import com.example.sully.quizwithserver.PlayfulActivities.P4Activity;
import com.example.sully.quizwithserver.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressLint("UseSparseArrays")
public class Q7Activity extends Manager {

    Map<Integer, String> dict = new HashMap<>();
    private ArrayList<Integer> checkboxesList = new ArrayList<>();

    @Override
    protected  void onCreate(Bundle bundle){
        super.onCreate(bundle);

        setContentView(R.layout.activity_q7);

        checkboxesList.add(R.id.rep7_A);    dict.put(R.id.rep7_A, getString(R.string.FRA_rep7_A));
        checkboxesList.add(R.id.rep7_B);    dict.put(R.id.rep7_B, "Internet");
        checkboxesList.add(R.id.rep7_C);    dict.put(R.id.rep7_C, "Reseaux");
        checkboxesList.add(R.id.rep7_D);    dict.put(R.id.rep7_D, getString(R.string.FRA_rep7_D));
        checkboxesList.add(R.id.rep7_E);    dict.put(R.id.rep7_E, "Tourisme");
        checkboxesList.add(R.id.rep7_F);    dict.put(R.id.rep7_F, "Prospectus");
        checkboxesList.add(R.id.rep7_G);    dict.put(R.id.rep7_G, "Proches");
        checkboxesList.add(R.id.rep7_H);    dict.put(R.id.rep7_H, "Collegues");
        checkboxesList.add(R.id.rep7_I);    dict.put(R.id.rep7_I, getString(R.string.FRA_rep7_I));

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

                ((TextView) findViewById(R.id.quest7)).setText(getString(R.string.FRA_quest7));

                ((TextView) findViewById(R.id.rep7_A)).setText(getString(R.string.FRA_rep7_A));
                ((TextView) findViewById(R.id.rep7_B)).setText(getString(R.string.FRA_rep7_B));
                ((TextView) findViewById(R.id.rep7_C)).setText(getString(R.string.FRA_rep7_C));
                ((TextView) findViewById(R.id.rep7_D)).setText(getString(R.string.FRA_rep7_D));
                ((TextView) findViewById(R.id.rep7_E)).setText(getString(R.string.FRA_rep7_E));
                ((TextView) findViewById(R.id.rep7_F)).setText(getString(R.string.FRA_rep7_F));
                ((TextView) findViewById(R.id.rep7_G)).setText(getString(R.string.FRA_rep7_G));
                ((TextView) findViewById(R.id.rep7_H)).setText(getString(R.string.FRA_rep7_H));
                ((TextView) findViewById(R.id.rep7_I)).setText(getString(R.string.FRA_rep7_I ));
                break;

            case "ANG":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ANG_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ANG_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ANG_cancelText));

                ((TextView) findViewById(R.id.quest7)).setText(getString(R.string.ANG_quest7));

                ((TextView) findViewById(R.id.rep7_A)).setText(getString(R.string.ANG_rep7_A));
                ((TextView) findViewById(R.id.rep7_B)).setText(getString(R.string.ANG_rep7_B));
                ((TextView) findViewById(R.id.rep7_C)).setText(getString(R.string.ANG_rep7_C));
                ((TextView) findViewById(R.id.rep7_D)).setText(getString(R.string.ANG_rep7_D));
                ((TextView) findViewById(R.id.rep7_E)).setText(getString(R.string.ANG_rep7_E));
                ((TextView) findViewById(R.id.rep7_F)).setText(getString(R.string.ANG_rep7_F));
                ((TextView) findViewById(R.id.rep7_G)).setText(getString(R.string.ANG_rep7_G));
                ((TextView) findViewById(R.id.rep7_H)).setText(getString(R.string.ANG_rep7_H));
                ((TextView) findViewById(R.id.rep7_I)).setText(getString(R.string.ANG_rep7_I ));
                break;
            case "ESP":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ESP_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ESP_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ESP_cancelText));

                ((TextView) findViewById(R.id.quest7)).setText(getString(R.string.ESP_quest7));

                ((TextView) findViewById(R.id.rep7_A)).setText(getString(R.string.ESP_rep7_A));
                ((TextView) findViewById(R.id.rep7_B)).setText(getString(R.string.ESP_rep7_B));
                ((TextView) findViewById(R.id.rep7_C)).setText(getString(R.string.ESP_rep7_C));
                ((TextView) findViewById(R.id.rep7_D)).setText(getString(R.string.ESP_rep7_D));
                ((TextView) findViewById(R.id.rep7_E)).setText(getString(R.string.ESP_rep7_E));
                ((TextView) findViewById(R.id.rep7_F)).setText(getString(R.string.ESP_rep7_F));
                ((TextView) findViewById(R.id.rep7_G)).setText(getString(R.string.ESP_rep7_G));
                ((TextView) findViewById(R.id.rep7_H)).setText(getString(R.string.ESP_rep7_H));
                ((TextView) findViewById(R.id.rep7_I)).setText(getString(R.string.ESP_rep7_I ));
                break;
        }

    }

    public void previousView(View view) {
        timer.interrupt();

        data.remove(data.size()-1);

        changeView(Q6Activity.class);
    }

    public void nextView(View view) {
        timer.interrupt();

        ArrayList<Integer> checkboxesList = treatmentCheckboxes(this.checkboxesList);
        StringBuilder s = new StringBuilder();

        for(int id : checkboxesList){
            s.append(dict.get(id)).append(" ");
        }

        if(s.length() > 0)
            data.add(s);
        else
            data.add(getString(R.string.FRA_rep7_I));

        changeView(P4Activity.class);
    }
}