package com.thinkgeniux.sportsmatch.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.thinkgeniux.sportsmatch.Adapters.Main_Videos_Adapter;
import com.thinkgeniux.sportsmatch.Adapters.Next_Videos_Adapter;
import com.thinkgeniux.sportsmatch.PojoClasses.Main_Video_Pojo;
import com.thinkgeniux.sportsmatch.R;

import java.util.ArrayList;

public class Videoplayer extends AppCompatActivity {

    MediaController mediaController;
    VideoView vv;
    String id;
    String uriString;
    ArrayList<Main_Video_Pojo> arrylist_video= new  ArrayList<>();
    String[] spinner_array = {"Not interested","Save to Watch Later", "Save to Playlist","Share","Report"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplayer);
        Intent intent=getIntent();

        id=intent.getStringExtra("id");
        mediaController =new  MediaController(this);
        vv = (VideoView)findViewById(R.id.main_videoView);

        arrylist_video.add(new Main_Video_Pojo("1",R.drawable.goals,R.drawable.goals,"ZAYN","MUSIC","3.25"
        ));

        arrylist_video.add(new Main_Video_Pojo("2",R.drawable.fight,R.drawable.fight,"ZAYN","MUSIC","3.25"
        ));

        arrylist_video.add(new Main_Video_Pojo("2",R.drawable.goals,R.drawable.goals,"ZAYN","MUSIC","3.25"
        ));

        arrylist_video.add(new Main_Video_Pojo("2",R.drawable.fight,R.drawable.fight,"ZAYN","MUSIC","3.25"
        ));
        if (id.equals("1")||id.equals("3"))
        {
         uriString = "android.resource://" + getPackageName() + "/" + R.raw.bestgoals;
        }else
            {
                uriString = "android.resource://" + getPackageName() + "/" + R.raw.fight;

            }
        vv.setVideoURI(Uri.parse(uriString));
        vv.setMediaController(mediaController);
        vv.setZOrderOnTop(true);
        vv.start();
        initnextrecycler();
    }
    private void initnextrecycler()
    {
        RecyclerView main_recycler=(RecyclerView)findViewById(R.id.next_rec);
        GridLayoutManager main_layoutmanger=new GridLayoutManager(Videoplayer.this,1);
        main_recycler.setLayoutManager(main_layoutmanger);
        main_recycler.setHasFixedSize(true);
        Next_Videos_Adapter Main_adapter=new Next_Videos_Adapter(arrylist_video,Videoplayer.this,spinner_array);
        main_recycler.setAdapter(Main_adapter);

    }
}
