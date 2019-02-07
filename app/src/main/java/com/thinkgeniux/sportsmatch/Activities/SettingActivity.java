package com.thinkgeniux.sportsmatch.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.thinkgeniux.sportsmatch.R;

public class SettingActivity extends AppCompatActivity {

    TextView gernal,autoplay,watchTv,downloads,histry_privacy,notifications,about,paid_member,caption_TV,connected_TV,
            livechatTV;
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
        histry_privacy=findViewById(R.id.histry_privacy);
        about=findViewById(R.id.about);
        paid_member=findViewById(R.id.paid_member);
        connected_TV=findViewById(R.id.connected_TV);
        notifications=findViewById(R.id.notifications);
        caption_TV=findViewById(R.id.caption_TV);
        livechatTV=findViewById(R.id.livechatTV);


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

        histry_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,History_and_Privacy.class);
                startActivity(intent);
            }
        });
        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,Notifications_Activity.class);
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,About_Activity.class);
                startActivity(intent);
            }
        });
        paid_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,Paid_Membership.class);
                startActivity(intent);
            }
        });

        caption_TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,Captions_Activity.class);
                startActivity(intent);
            }
        });

        connected_TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,Connected_accounts.class);
                startActivity(intent);

            }
        });

        livechatTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingActivity.this,Live_Chat.class);
                startActivity(intent);
            }
        });
    }
}
