package com.thinkgeniux.sportsmatch.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Switch;

import com.thinkgeniux.sportsmatch.R;

public class Time_Watched extends AppCompatActivity {
    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time__watched);
        switch1=findViewById(R.id.switch1);

    }
}