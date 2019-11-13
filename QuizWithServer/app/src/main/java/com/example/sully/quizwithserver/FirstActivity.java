package com.example.sully.quizwithserver;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.sully.quizwithserver.QuestionsActivities.Q1Activity;


public class FirstActivity extends Manager {

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_first);
    }

    public void FRA_langage(View v){
        lang = "FRA";
        Intent intent = new Intent(getApplicationContext(),Q1Activity.class);
        startActivity(intent);
    }

    public void ESP_langage(View v){
        lang = "ESP";
        Intent intent = new Intent(getApplicationContext(),Q1Activity.class);
        startActivity(intent);
    }

    public void ANG_langage(View v){
        lang = "ANG";
        Intent intent = new Intent(getApplicationContext(),Q1Activity.class);
        startActivity(intent);
    }
}
