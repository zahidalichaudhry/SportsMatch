package com.thinkgeniux.sportsmatch.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.thinkgeniux.sportsmatch.R;

public class Captions_Activity extends AppCompatActivity {
    TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captions_);
        tv_title=(TextView)findViewById(R.id.tv_title);
        tv_title.setText("Captions");

    }
}
