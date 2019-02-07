package com.thinkgeniux.sportsmatch.Activities;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.thinkgeniux.sportsmatch.Fragments.About_channel;
import com.thinkgeniux.sportsmatch.Fragments.Chanels_chanel;
import com.thinkgeniux.sportsmatch.Fragments.Home_Chanel;
import com.thinkgeniux.sportsmatch.Fragments.Playlist_chanel;
import com.thinkgeniux.sportsmatch.Fragments.Video_Chanel;
import com.thinkgeniux.sportsmatch.Fragments.messages;
import com.thinkgeniux.sportsmatch.Fragments.notifications;
import com.thinkgeniux.sportsmatch.R;

import java.util.ArrayList;
import java.util.List;

public class MyChanel extends AppCompatActivity
{
    ImageView img_home,img_trend,img_sub,img_lib;
    TextView tv_home,tv_trend,tv_sub,tv_lib;
    ConstraintLayout cl_history,cl_my_videos,cl_downloads,cl_watch_later;
    ImageView img_top_video,img_search,img_profile;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ConstraintLayout cl_home,cl_trnd,cl_sub,cl_inbox,cl_lib;
    TextView tv_title;
    Spinner videoSpinner;
    String spinner_selected;
    String[] spinner_array = {"Share", "Settings","Terms & privacy policy","Help & feedback"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_chanel);
        Toolbrinit();
        iniBottomnav();
        iniUI();
        iniSpinner();
    }

    private void iniSpinner()
    {
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (MyChanel.this, android.R.layout.simple_spinner_item,
                        spinner_array);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        videoSpinner.setAdapter(spinnerArrayAdapter);

        videoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                // Notify the selected item text
                spinner_selected = (String) adapterView.getSelectedItem();
                //   Toast.makeText(activity,spinner_selected,Toast.LENGTH_LONG).show();

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void iniUI()
    {
        tv_title=(TextView)findViewById(R.id.tv_title);
        tv_title.setText("NAME");
        videoSpinner=(Spinner) findViewById(R.id.videoSpinner);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
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
                MyChanel.super.onBackPressed();
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
                Intent intent = new Intent(MyChanel.this,MainListVideos.class);
                startActivity(intent);
            }
        });
        cl_trnd=(ConstraintLayout)findViewById(R.id.cl_trend);
        img_trend=(ImageView)findViewById(R.id.img_trending);
        tv_trend=(TextView)findViewById(R.id.tv_trending);
        cl_trnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyChanel.this,MainListVideos.class);
                startActivity(intent);
            }
        });
        cl_sub=(ConstraintLayout)findViewById(R.id.cl_sub);
        tv_sub=(TextView)findViewById(R.id.tv_sub);
        img_sub=(ImageView)findViewById(R.id.img_sub);
        cl_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyChanel.this,MainListVideos.class);
                startActivity(intent);
            }
        });

        cl_inbox=(ConstraintLayout)findViewById(R.id.cl_inbox);
        cl_inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyChanel.this,Inbox.class);
                startActivity(intent);
            }
        });
        cl_lib=(ConstraintLayout)findViewById(R.id.cl_lib);
        img_lib=(ImageView)findViewById(R.id.img_lib);
        img_lib.setImageResource(R.drawable.red_folder);
        tv_lib=(TextView)findViewById(R.id.tv_lib);
        tv_lib.setTextColor(ContextCompat.getColor(MyChanel.this,R.color.red));
    }
    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Home_Chanel(), " HOME ");
        adapter.addFragment(new Video_Chanel(), " VIDEO ");
        adapter.addFragment(new Playlist_chanel(), " PLAYLISTS ");
        adapter.addFragment(new Chanels_chanel(), " CHANNELS ");
        adapter.addFragment(new About_channel(), " ABOUT ");
        viewPager.setAdapter(adapter);
    }
    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
