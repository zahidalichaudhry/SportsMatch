package com.thinkgeniux.sportsmatch.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.thinkgeniux.sportsmatch.Adapters.All_VideosAdapter;
import com.thinkgeniux.sportsmatch.PojoClasses.MyVideoPojo;
import com.thinkgeniux.sportsmatch.R;

import java.util.ArrayList;

public class All_Videos extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MyVideoPojo> myVideoPojos=new ArrayList<>();
    All_VideosAdapter adapter;
    ArrayList<String> spinerlist=new ArrayList<>();
    TextView tv_title;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_videos);
        Toolbrinit();
        Intent intent=getIntent();
        title= intent.getStringExtra("title");
        tv_title=(TextView)findViewById(R.id.tv_title);
        tv_title.setText(title);
        myVideoPojos.add(new MyVideoPojo(R.drawable.trese,"Natural beauty","One year Ago"));
        myVideoPojos.add(new MyVideoPojo(R.drawable.sports,"A beautiful Scene","Three Months Ago"));
        myVideoPojos.add(new MyVideoPojo(R.drawable.watch,"A beautiful Watch","two Months Ago"));
        myVideoPojos.add(new MyVideoPojo(R.drawable.river,"A beautiful river","One day Ago"));
        IniVideoAdapter();

    }

    private void IniVideoAdapter()
    {
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new All_VideosAdapter(myVideoPojos,spinerlist,All_Videos.this);
        recyclerView.setAdapter(adapter);
    }
    private void Toolbrinit()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                All_Videos.super.onBackPressed();
            }
        });
    }
}
