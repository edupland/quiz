package com.example.sully.quizwithserver.QuestionsActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.example.sully.quizwithserver.Manager;
import com.example.sully.quizwithserver.PlayfulActivities.P6Activity;
import com.example.sully.quizwithserver.R;
import java.text.MessageFormat;

public class Q10Activity extends Manager {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_q10);
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

                ((TextView) findViewById(R.id.quest10)).setText(getString(R.string.FRA_quest10));
                break;

            case "ANG":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ANG_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ANG_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ANG_cancelText));

                ((TextView) findViewById(R.id.quest10)).setText(getString(R.string.ANG_quest10));
                break;
            case "ESP":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ESP_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ESP_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ESP_cancelText));

                ((TextView) findViewById(R.id.quest10)).setText(getString(R.string.ESP_quest10));
                break;
        }

        ((TextView) findViewById(R.id.showRep10)).setText(MessageFormat.format("{0}", ((SeekBar) findViewById(R.id.rep10)).getProgress()));

        ((SeekBar) findViewById(R.id.rep10)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ((TextView) findViewById(R.id.showRep10)).setText(MessageFormat.format("{0}", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                timer.interrupt();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                timer = setTimer();
                timer.start();
            }
        });
    }

    public void previousView(View view) {
        data.remove(data.size()-1);
        timer.interrupt();

        changeView(Q9Activity.class);
    }

    public void nextView(View view) {

        data.add(((SeekBar) findViewById(R.id.rep10)).getProgress());
        timer.interrupt();

        changeView(P6Activity.class);
    }
}
