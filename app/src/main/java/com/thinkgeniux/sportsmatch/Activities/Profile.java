package com.thinkgeniux.sportsmatch.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.thinkgeniux.sportsmatch.R;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
   TextView textView2;
    Spinner spinner;
    ArrayAdapter<CharSequence> arrayAdapter;
    ImageView img_cross;
    ArrayList<String>spinner_arrylist=new ArrayList<>();
    ConstraintLayout cl_my_chanel,cl_settings,cl_time_watched,cl_paid,cl_switch,cl_turn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textView2=findViewById(R.id.textView2);

        spinner=findViewById(R.id.spinner);
    //    arrayAdapter= ArrayAdapter.createFromResource(this,R.array.spinnerdemo,android.R.layout.simple_spinner_item);
      //  arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_arrylist.add("Account Name");
        spinner_arrylist.add("Accounts             +");
        spinner_arrylist.add("fakharali054@gmail.com");
         ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                Profile.this,R.layout.spinner_item_accounts,spinner_arrylist){
             @Override
             public View getDropDownView(int position, View convertView,
                                         ViewGroup parent) {
                 View view = super.getDropDownView(position, convertView, parent);
                 TextView tv = (TextView) view;
                 if(position == 0){
                     // Set the hint text color gray
                     tv.setTextColor(ContextCompat.getColor(Profile.this,R.color.black));
                 }
                 else {
                     tv.setTextColor(ContextCompat.getColor(Profile.this,R.color.black));
                 }
                 return view;
             }
        };
        spinner.setAdapter(spinnerArrayAdapter);
        iniUI();
//
//        textView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Profile.this,Videos.class);
//                startActivity(intent);
//            }
//        });
    }

    private void iniUI()
    {
        img_cross=(ImageView)findViewById(R.id.img_cross);
        img_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,MainListVideos.class);
                startActivity(intent);
            }
        });
        cl_my_chanel=(ConstraintLayout)findViewById(R.id.cl_my_chanel);
        cl_my_chanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,MyChanel.class);
                startActivity(intent);
            }
        });
        cl_settings=(ConstraintLayout)findViewById(R.id.cl_settings);
        cl_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,SettingActivity.class);
                startActivity(intent);
            }
        });
        cl_time_watched=(ConstraintLayout)findViewById(R.id.cl_time_watched);
        cl_time_watched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,Time_Watched.class);
                startActivity(intent);
            }
        });
        cl_paid=(ConstraintLayout)findViewById(R.id.cl_paid);
        cl_paid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this,Paid_Membership.class);
                startActivity(intent);
            }
        });
        cl_switch=(ConstraintLayout)findViewById(R.id.cl_switch);
        cl_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            }
        });
        cl_turn=(ConstraintLayout)findViewById(R.id.cl_turn_inc);
        cl_turn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

}
