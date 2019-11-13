package com.example.sully.quizwithserver.QuestionsActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sully.quizwithserver.Manager;
import com.example.sully.quizwithserver.R;

public class Q8Activity extends Manager {

    //TODO
    //Question plus explicif

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_q8);
    }

    @Override
    protected void onStart() {
        super.onStart();

        timer = setTimer();
        timer.start();

        switch (lang) {
            case "FRA":
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.FRA_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.FRA_cancelText));

                ((TextView) findViewById(R.id.quest8)).setText(getString(R.string.FRA_quest8));
                break;

            case "ANG":
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ANG_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ANG_cancelText));

                ((TextView) findViewById(R.id.quest8)).setText(getString(R.string.ANG_quest8));
                break;
            case "ESP":
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ESP_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ESP_cancelText));

                ((TextView) findViewById(R.id.quest8)).setText(getString(R.string.ESP_quest8));
                break;
        }

        findViewById(R.id.rep8_A).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.add(getString(R.string.rep8_A));
                nextView(v);
            }
        });

        findViewById(R.id.rep8_B).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.add(getString(R.string.rep8_B));
                nextView(v);
            }
        });

        findViewById(R.id.rep8_C).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.add(getString(R.string.rep8_C));
                nextView(v);
            }
        });
    }

    public void previousView(View view) {
        data.remove(data.size()-1);

        timer.interrupt();

        changeView(Q7Activity.class);
    }

    public void nextView(View view) {
        timer.interrupt();

        changeView(Q9Activity.class);
    }
}
