package com.thinkgeniux.sportsmatch.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.thinkgeniux.sportsmatch.Adapters.Main_Videos_Adapter;
import com.thinkgeniux.sportsmatch.Adapters.Stories_Adapter_horizontal;
import com.thinkgeniux.sportsmatch.PojoClasses.Main_Video_Pojo;
import com.thinkgeniux.sportsmatch.PojoClasses.Stories;
import com.thinkgeniux.sportsmatch.R;

import java.util.ArrayList;

public class MainListVideos extends AppCompatActivity {
//    RecyclerView horizental_reycler,main_recycler;
    ArrayList<Stories> arrylist_stroies= new  ArrayList<>();
    ArrayList<Main_Video_Pojo> arrylist_video= new  ArrayList<>();
    String[] spinner_array = {"Not interested","Save to Watch Later", "Save to Playlist","Share","Report"};

    ConstraintLayout cl_home,cl_trnd,cl_sub,cl_inbox,cl_lib;
    ImageView img_home,img_trend,img_sub;
    TextView tv_home,tv_trend,tv_sub;
    //String[] spinner_array=new String[5];
    ImageView img_top_video,img_search,img_profile;
    ImageView search_app_bar;
    EditText search_edit;
    boolean search_show=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_videos);

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
        iniTopview();
        initmainrecycler();
        initHorizontalrecycler();
    }

    private void iniTopview()
    {
        img_top_video=(ImageView)findViewById(R.id.img_top_video);
       // img_search=(ImageView)findViewById(R.id.search_ap_bar);
        img_profile=(ImageView)findViewById(R.id.img_profile);
        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainListVideos.this,Profile.class);
                startActivity(intent);
            }
        });
        search_edit=(EditText)findViewById(R.id.search_edit);
        search_edit.setVisibility(View.GONE);
        search_app_bar=(ImageView)findViewById(R.id.search_ap_bar);
        search_app_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!search_show){
                    search_edit.setVisibility(View.VISIBLE);
                    search_show=true;
                }else if (search_edit.getText().length()==0)
                {
                    search_edit.setVisibility(View.GONE);
                    search_show=false;
                }else
                {
                    //search_activity_start();
                    search_edit.setVisibility(View.GONE);
                    search_show=false;
                }
            }
        });
    }

    private void iniBottomnav()
    {
        cl_home=(ConstraintLayout)findViewById(R.id.cl_home);
        img_home=(ImageView)findViewById(R.id.img_home);
        tv_home=(TextView)findViewById(R.id.tv_home);
        tv_home.setTextColor(ContextCompat.getColor(MainListVideos.this,R.color.red));
        img_home.setImageResource(R.drawable.red_home);
        cl_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   Toast.makeText(MainListVideos.this, "Already On Home", Toast.LENGTH_SHORT).show();
                tv_home.setTextColor(ContextCompat.getColor(MainListVideos.this,R.color.red));
                img_home.setImageResource(R.drawable.red_home);
                tv_sub.setTextColor(ContextCompat.getColor(MainListVideos.this,R.color.black));
                img_sub.setImageResource(R.drawable.black_video_list);
                tv_trend.setTextColor(ContextCompat.getColor(MainListVideos.this,R.color.black));
                img_trend.setImageResource(R.drawable.black_fire);
            }
        });
        cl_trnd=(ConstraintLayout)findViewById(R.id.cl_trend);
        img_trend=(ImageView)findViewById(R.id.img_trending);
        tv_trend=(TextView)findViewById(R.id.tv_trending);
        cl_trnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_trend.setTextColor(ContextCompat.getColor(MainListVideos.this,R.color.red));
                img_trend.setImageResource(R.drawable.red_fire);
                tv_home.setTextColor(ContextCompat.getColor(MainListVideos.this,R.color.black));
                img_home.setImageResource(R.drawable.black_home);
                tv_sub.setTextColor(ContextCompat.getColor(MainListVideos.this,R.color.black));
                img_sub.setImageResource(R.drawable.black_video_list);
            }
        });
        cl_sub=(ConstraintLayout)findViewById(R.id.cl_sub);
        tv_sub=(TextView)findViewById(R.id.tv_sub);
        img_sub=(ImageView)findViewById(R.id.img_sub);
        cl_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_sub.setTextColor(ContextCompat.getColor(MainListVideos.this,R.color.red));
                img_sub.setImageResource(R.drawable.red_video_list);
                tv_home.setTextColor(ContextCompat.getColor(MainListVideos.this,R.color.black));
                img_home.setImageResource(R.drawable.black_home);
                tv_trend.setTextColor(ContextCompat.getColor(MainListVideos.this,R.color.black));
                img_trend.setImageResource(R.drawable.black_fire);
            }
        });

        cl_inbox=(ConstraintLayout)findViewById(R.id.cl_inbox);
        cl_inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainListVideos.this,Inbox.class);
                startActivity(intent);
            }
        });
        cl_lib=(ConstraintLayout)findViewById(R.id.cl_lib);
        cl_lib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainListVideos.this,Libarary.class);
                startActivity(intent);
            }
        });

    }

    private void initmainrecycler()
    {
        RecyclerView main_recycler=(RecyclerView)findViewById(R.id.main_recycler);
        GridLayoutManager main_layoutmanger=new GridLayoutManager(MainListVideos.this,1);
        main_recycler.setLayoutManager(main_layoutmanger);
        main_recycler.setNestedScrollingEnabled(false);
        main_recycler.setHasFixedSize(true);
        Main_Videos_Adapter Main_adapter=new Main_Videos_Adapter(arrylist_video,MainListVideos.this,spinner_array);
        main_recycler.setAdapter(Main_adapter);

    }

    private void initHorizontalrecycler()
    {
        RecyclerView horizental_reycler=(RecyclerView)findViewById(R.id.horizontal_recyler);
        horizental_reycler.setHasFixedSize(true);
        Stories_Adapter_horizontal horizontal_adapter=new Stories_Adapter_horizontal(arrylist_stroies,MainListVideos.this);
        horizental_reycler.setAdapter(horizontal_adapter);
    }
}