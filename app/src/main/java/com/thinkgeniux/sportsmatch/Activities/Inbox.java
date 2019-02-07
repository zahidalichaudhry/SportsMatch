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
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thinkgeniux.sportsmatch.Fragments.messages;
import com.thinkgeniux.sportsmatch.Fragments.notifications;
import com.thinkgeniux.sportsmatch.R;

import java.util.ArrayList;
import java.util.List;

public class Inbox extends AppCompatActivity {
    ConstraintLayout cl_home,cl_trnd,cl_sub,cl_inbox,cl_lib;
    ImageView img_home,img_trend,img_sub,img_lib,img_inbox;
    TextView tv_home,tv_trend,tv_sub,tv_lib,tv_inbox;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ImageView img_top_video,img_search,img_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        iniUI();
        iniTopview();
        iniBottomnav();
    }

    private void iniUI()
    {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void iniTopview()
    {
        img_top_video=(ImageView)findViewById(R.id.img_top_video);
        img_search=(ImageView)findViewById(R.id.search_ap_bar);
        img_profile=(ImageView)findViewById(R.id.img_profile);
        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inbox.this,Profile.class);
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
                Intent intent = new Intent(Inbox.this,MainListVideos.class);
                startActivity(intent);
            }
        });
        cl_trnd=(ConstraintLayout)findViewById(R.id.cl_trend);
        img_trend=(ImageView)findViewById(R.id.img_trending);
        tv_trend=(TextView)findViewById(R.id.tv_trending);
        cl_trnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inbox.this,MainListVideos.class);
                startActivity(intent);
            }
        });
        cl_sub=(ConstraintLayout)findViewById(R.id.cl_sub);
        tv_sub=(TextView)findViewById(R.id.tv_sub);
        img_sub=(ImageView)findViewById(R.id.img_sub);
        cl_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inbox.this,MainListVideos.class);
                startActivity(intent);
            }
        });

        cl_inbox=(ConstraintLayout)findViewById(R.id.cl_inbox);
        cl_lib=(ConstraintLayout)findViewById(R.id.cl_lib);
        cl_lib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Inbox.this,Libarary.class);
                startActivity(intent);
            }
        });
        img_inbox=(ImageView)findViewById(R.id.img_inbox);
        img_inbox.setImageResource(R.drawable.red_envelope);
        tv_inbox=(TextView)findViewById(R.id.tv_inbox);
        tv_inbox.setTextColor(ContextCompat.getColor(Inbox.this,R.color.red));


    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new messages(), "MESSAGES");
        adapter.addFragment(new notifications(), "NOTIFICATIONS");
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
