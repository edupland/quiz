package com.example.sully.quizwithserver;

import android.os.Bundle;

public class LastActivity extends Manager {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        timer = setTimer(5000);
        timer.start();
    }
}
