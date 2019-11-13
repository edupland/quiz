package com.example.sully.quizwithserver.QuestionsActivities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.sully.quizwithserver.Manager;
import com.example.sully.quizwithserver.R;
import java.util.HashMap;
import java.util.Map;

@SuppressLint("UseSparseArrays")
public class Q3Activity extends Manager {

    RadioGroup grp;
    Map<Integer, String> dict = new HashMap<>();

    @Override
    protected  void onCreate(Bundle bundle){
        super.onCreate(bundle);

        setContentView(R.layout.activity_q3);

        grp = findViewById(R.id.radioGRP);

        dict.put(R.id.rep3_C,getString(R.string.FRA_rep3_C));
        dict.put(R.id.rep3_D,getString(R.string.FRA_rep3_D));
        dict.put(R.id.rep3_E,getString(R.string.FRA_rep3_E));
        dict.put(R.id.rep3_F,getString(R.string.FRA_rep3_F));
        dict.put(R.id.rep3_G,"BAC+");

    }

    @Override
    protected void onStart() {
        super.onStart();

        timer = setTimer();
        timer.start();

        if(isYoung) {
            dict.put(R.id.rep3_A, "Primaire");
            dict.put(R.id.rep3_B, "College");
        }else {
            dict.put(R.id.rep3_A, getString(R.string.FRA_rep3_BA));
            dict.put(R.id.rep3_B, getString(R.string.FRA_rep3_BB));
        }

        switch (lang) {
            case "FRA":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.FRA_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.FRA_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.FRA_cancelText));

                if(isYoung) {
                    ((TextView) findViewById(R.id.quest3)).setText(getString(R.string.FRA_quest3_A));

                    ((TextView) findViewById(R.id.rep3_A)).setText(getString(R.string.FRA_rep3_AA));
                    ((TextView) findViewById(R.id.rep3_B)).setText(getString(R.string.FRA_rep3_AB));
                    findViewById(R.id.rep3_C).setVisibility(View.GONE);
                    findViewById(R.id.rep3_D).setVisibility(View.GONE);
                    findViewById(R.id.rep3_E).setVisibility(View.GONE);
                    findViewById(R.id.rep3_F).setVisibility(View.GONE);
                    findViewById(R.id.rep3_G).setVisibility(View.GONE);
                }else{
                    ((TextView) findViewById(R.id.quest3)).setText(getString(R.string.FRA_quest3_B));

                    ((TextView) findViewById(R.id.rep3_A)).setText(getString(R.string.FRA_rep3_BA));
                    ((TextView) findViewById(R.id.rep3_B)).setText(getString(R.string.FRA_rep3_BB));
                    ((TextView) findViewById(R.id.rep3_C)).setText(getString(R.string.FRA_rep3_C));
                    ((TextView) findViewById(R.id.rep3_D)).setText(getString(R.string.FRA_rep3_D));
                    ((TextView) findViewById(R.id.rep3_E)).setText(getString(R.string.FRA_rep3_E));
                    ((TextView) findViewById(R.id.rep3_F)).setText(getString(R.string.FRA_rep3_F));
                }
                break;

            case "ANG":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ANG_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ANG_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ANG_cancelText));

                if(isYoung) {
                    ((TextView) findViewById(R.id.quest3)).setText(getString(R.string.FRA_quest3_A));

                    ((TextView) findViewById(R.id.rep3_A)).setText(getString(R.string.ANG_rep3_AA));
                    ((TextView) findViewById(R.id.rep3_B)).setText(getString(R.string.ANG_rep3_AB));
                    findViewById(R.id.rep3_C).setVisibility(View.GONE);
                    findViewById(R.id.rep3_D).setVisibility(View.GONE);
                    findViewById(R.id.rep3_E).setVisibility(View.GONE);
                    findViewById(R.id.rep3_F).setVisibility(View.GONE);
                    findViewById(R.id.rep3_G).setVisibility(View.GONE);
                }else{
                    ((TextView) findViewById(R.id.quest3)).setText(getString(R.string.ANG_quest3_B));

                    ((TextView) findViewById(R.id.rep3_A)).setText(getString(R.string.ANG_rep3_BA));
                    ((TextView) findViewById(R.id.rep3_B)).setText(getString(R.string.ANG_rep3_BB));
                    ((TextView) findViewById(R.id.rep3_C)).setText(getString(R.string.ANG_rep3_C));
                    ((TextView) findViewById(R.id.rep3_D)).setText(getString(R.string.ANG_rep3_D));
                    ((TextView) findViewById(R.id.rep3_E)).setText(getString(R.string.ANG_rep3_E));
                    ((TextView) findViewById(R.id.rep3_F)).setText(getString(R.string.ANG_rep3_F));
                }
                break;
            case "ESP":
                ((TextView) findViewById(R.id.nextButton)).setText(getString(R.string.ESP_nextText));
                ((TextView) findViewById(R.id.prevButton)).setText(getString(R.string.ESP_backText));
                ((TextView) findViewById(R.id.cancelButton)).setText(getString(R.string.ESP_cancelText));

                if(isYoung) {
                    ((TextView) findViewById(R.id.quest3)).setText(getString(R.string.FRA_quest3_A));

                    ((TextView) findViewById(R.id.rep3_A)).setText(getString(R.string.ESP_rep3_AA));
                    ((TextView) findViewById(R.id.rep3_B)).setText(getString(R.string.ESP_rep3_AB));
                    findViewById(R.id.rep3_C).setVisibility(View.GONE);
                    findViewById(R.id.rep3_D).setVisibility(View.GONE);
                    findViewById(R.id.rep3_E).setVisibility(View.GONE);
                    findViewById(R.id.rep3_F).setVisibility(View.GONE);
                    findViewById(R.id.rep3_G).setVisibility(View.GONE);
                }else{
                    ((TextView) findViewById(R.id.quest3)).setText(getString(R.string.ESP_quest3_B));

                    ((TextView) findViewById(R.id.rep3_A)).setText(getString(R.string.ESP_rep3_BA));
                    ((TextView) findViewById(R.id.rep3_B)).setText(getString(R.string.ESP_rep3_BB));
                    ((TextView) findViewById(R.id.rep3_C)).setText(getString(R.string.ESP_rep3_C));
                    ((TextView) findViewById(R.id.rep3_D)).setText(getString(R.string.ESP_rep3_D));
                    ((TextView) findViewById(R.id.rep3_E)).setText(getString(R.string.ESP_rep3_E));
                    ((TextView) findViewById(R.id.rep3_F)).setText(getString(R.string.ESP_rep3_F));
                }
                break;
        }
    }


    public void previousView(View view) {
        timer.interrupt();

        data.remove(data.size()-1);

        changeView(Q2Activity.class);
    }

    public void nextView(View view) {
        timer.interrupt();

        data.add(dict.get(grp.getCheckedRadioButtonId()));

        changeView(Q4Activity.class);
    }
}
