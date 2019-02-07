package com.thinkgeniux.sportsmatch.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.thinkgeniux.sportsmatch.R;

public class SettingActivity extends AppCompatActivity {

    TextView gernal,autoplay,watchTv,downloads;
    TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        tv_title=(TextView)findViewById(R.id.tv_title);
        tv_title.setText("Settings");

        gernal=findViewById(R.id.gernal);
        autoplay=findViewById(R.id.autoplay);
        downloads=findViewById(R.id.downloads);
        watchTv=findViewById(R.id.watchTv);


        gernal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,Gernal_Activity.class);
                startActivity(intent);
            }
        });

        autoplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,AutoPlay.class);
                startActivity(intent);
            }
        });

        downloads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,Downloads.class);
                startActivity(intent);
            }
        });

        watchTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,Watch_on_TV.class);
                startActivity(intent);
            }
        });
    }
}
