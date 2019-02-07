package com.thinkgeniux.sportsmatch.Activities;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thinkgeniux.sportsmatch.Adapters.Main_Videos_Adapter;
import com.thinkgeniux.sportsmatch.Adapters.Main_library_Adapter;
import com.thinkgeniux.sportsmatch.Adapters.Stories_Adapter_horizontal;
import com.thinkgeniux.sportsmatch.Adapters.library_Adapter_horizontal;
import com.thinkgeniux.sportsmatch.PojoClasses.Main_Video_Pojo;
import com.thinkgeniux.sportsmatch.PojoClasses.Stories;
import com.thinkgeniux.sportsmatch.R;

import java.util.ArrayList;

public class Libarary extends AppCompatActivity {
    ArrayList<Stories> arrylist_stroies= new  ArrayList<>();
    ArrayList<Main_Video_Pojo> arrylist_video= new  ArrayList<>();
    String[] spinner_array = {"Remove from Watch History","Save to Watch Later", "Save to Playlist","Share","Download"};

    ConstraintLayout cl_home,cl_trnd,cl_sub,cl_inbox,cl_lib;
    ImageView img_home,img_trend,img_sub,img_lib;
    TextView tv_home,tv_trend,tv_sub,tv_lib;
    ConstraintLayout cl_history,cl_my_videos,cl_downloads,cl_watch_later;
    ImageView img_top_video,img_search,img_profile;
    //String[] spinner_array=new String[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libarary);

        arrylist_stroies.add(new Stories("1","Zayn",R.drawable.goals));
        arrylist_stroies.add(new Stories("2","xmen",R.drawable.fight));
        arrylist_stroies.add(new Stories("3","Zayn",R.drawable.goals));
        arrylist_stroies.add(new Stories("4","xmen",R.drawable.fight));

        arrylist_video.add(new Main_Video_Pojo("1",R.drawable.goals,R.drawable.goals,"ZAYN","MUSIC","3.25"
        ));

        arrylist_video.add(new Main_Video_Pojo("2",R.drawable.fight,R.drawable.fight,"ZAYN","MUSIC","3.25"
        ));

        arrylist_video.add(new Main_Video_Pojo("2",R.drawable.goals,R.drawable.goals,"ZAYN","MUSIC","3.25"
        ));

        arrylist_video.add(new Main_Video_Pojo("2",R.drawable.fight,R.drawable.fight,"ZAYN","MUSIC","3.25"
        ));
        iniBottomnav();
        initUI();
        iniTopview();
        initmainrecycler();
        initHorizontalrecycler();
    }

    private void iniTopview()
    {
        img_top_video=(ImageView)findViewById(R.id.img_top_video);
        img_search=(ImageView)findViewById(R.id.search_ap_bar);
        img_profile=(ImageView)findViewById(R.id.img_profile);
        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Libarary.this,Profile.class);
                startActivity(intent);
            }
        });
    }
    private void initUI()
    {
        cl_history=(ConstraintLayout)findViewById(R.id.cl_history);
        cl_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Libarary.this,All_Videos.class);
                intent.putExtra("title","History");
                startActivity(intent);
            }
        });
        cl_downloads=(ConstraintLayout)findViewById(R.id.cl_downlaods);
        cl_downloads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Libarary.this,All_Videos.class);
                intent.putExtra("title","Library");
                startActivity(intent);
            }
        });
        cl_my_videos=(ConstraintLayout)findViewById(R.id.cl_my_videos);
        cl_my_videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Libarary.this,All_Videos.class);
                intent.putExtra("title","My Videos");
                startActivity(intent);
            }
        });
        cl_watch_later=(ConstraintLayout)findViewById(R.id.cl_watch_later);
        cl_watch_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Libarary.this,All_Videos.class);
                intent.putExtra("title","Watch Later");
                startActivity(intent);
            }
        });
    }

    private void iniBottomnav()
    {
        cl_home=(ConstraintLayout)findViewById(R.id.cl_home);
        img_home=(ImageView)findViewById(R.id.img_home);
        tv_home=(TextView)findViewById(R.id.tv_home);
        cl_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   Toast.makeText(MainListVideos.this, "Already On Home", Toast.LENGTH_SHORT).show();
      /*          tv_home.setTextColor(ContextCompat.getColor(Libarary.this,R.color.red));
                img_home.setImageResource(R.drawable.red_home);
                tv_sub.setTextColor(ContextCompat.getColor(Libarary.this,R.color.black));
                img_sub.setImageResource(R.drawable.black_video_list);
                tv_trend.setTextColor(ContextCompat.getColor(Libarary.this,R.color.black));
                img_trend.setImageResource(R.drawable.black_fire);*/
                Intent intent = new Intent(Libarary.this,MainListVideos.class);
                startActivity(intent);
            }
        });
        cl_trnd=(ConstraintLayout)findViewById(R.id.cl_trend);
        img_trend=(ImageView)findViewById(R.id.img_trending);
        tv_trend=(TextView)findViewById(R.id.tv_trending);
        cl_trnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                tv_trend.setTextColor(ContextCompat.getColor(Libarary.this,R.color.red));
//                img_trend.setImageResource(R.drawable.red_fire);
//                tv_home.setTextColor(ContextCompat.getColor(Libarary.this,R.color.black));
//                img_home.setImageResource(R.drawable.black_home);
//                tv_sub.setTextColor(ContextCompat.getColor(Libarary.this,R.color.black));
//                img_sub.setImageResource(R.drawable.black_video_list);
                Intent intent = new Intent(Libarary.this,MainListVideos.class);
                startActivity(intent);
            }
        });
        cl_sub=(ConstraintLayout)findViewById(R.id.cl_sub);
        tv_sub=(TextView)findViewById(R.id.tv_sub);
        img_sub=(ImageView)findViewById(R.id.img_sub);
        cl_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                tv_sub.setTextColor(ContextCompat.getColor(Libarary.this,R.color.red));
//                img_sub.setImageResource(R.drawable.red_video_list);
//                tv_home.setTextColor(ContextCompat.getColor(Libarary.this,R.color.black));
//                img_home.setImageResource(R.drawable.black_home);
//                tv_trend.setTextColor(ContextCompat.getColor(Libarary.this,R.color.black));
//                img_trend.setImageResource(R.drawable.black_fire);
                Intent intent = new Intent(Libarary.this,MainListVideos.class);
                startActivity(intent);
            }
        });

        cl_inbox=(ConstraintLayout)findViewById(R.id.cl_inbox);
        cl_inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Libarary.this,Inbox.class);
                startActivity(intent);
            }
        });
        cl_lib=(ConstraintLayout)findViewById(R.id.cl_lib);
        img_lib=(ImageView)findViewById(R.id.img_lib);
        img_lib.setImageResource(R.drawable.red_folder);
        tv_lib=(TextView)findViewById(R.id.tv_lib);
        tv_lib.setTextColor(ContextCompat.getColor(Libarary.this,R.color.red));


    }

    private void initmainrecycler()
    {
        RecyclerView main_recycler=(RecyclerView)findViewById(R.id.main_recycler);
        GridLayoutManager main_layoutmanger=new GridLayoutManager(Libarary.this,1);
        main_recycler.setLayoutManager(main_layoutmanger);
        main_recycler.setNestedScrollingEnabled(false);
        main_recycler.setHasFixedSize(true);
        Main_library_Adapter Main_adapter=new Main_library_Adapter(arrylist_video,Libarary.this);
        main_recycler.setAdapter(Main_adapter);

    }

    private void initHorizontalrecycler()
    {
        RecyclerView horizental_reycler=(RecyclerView)findViewById(R.id.horizontal_recyler);
        horizental_reycler.setHasFixedSize(true);
        library_Adapter_horizontal horizontal_adapter=new library_Adapter_horizontal(arrylist_video,Libarary.this,spinner_array);
        horizental_reycler.setAdapter(horizontal_adapter);

    }
}
