package com.thinkgeniux.sportsmatch.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thinkgeniux.sportsmatch.Adapters.Chanels_channel_Adapter;
import com.thinkgeniux.sportsmatch.Adapters.Next_Videos_Adapter;
import com.thinkgeniux.sportsmatch.PojoClasses.Main_Video_Pojo;
import com.thinkgeniux.sportsmatch.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Chanels_chanel extends Fragment {

    String uriString;
    ArrayList<Main_Video_Pojo> arrylist_video= new  ArrayList<>();
    String[] spinner_array = {"Share"};
    RecyclerView main_recycler;
    public Chanels_chanel() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_chanels_chanel, container, false);
        arrylist_video.add(new Main_Video_Pojo("1",R.drawable.goals,R.drawable.goals,
                "FOOTBALL","SPORTS","11"
        ));
        arrylist_video.add(new Main_Video_Pojo("2",R.drawable.fight,R.drawable.fight,
                "MMA","SPORTS","12"
        ));
        arrylist_video.add(new Main_Video_Pojo("2",R.drawable.goals,R.drawable.goals,
                "FOOTBALL","SPORTS","21"
        ));
        arrylist_video.add(new Main_Video_Pojo("2",R.drawable.fight,R.drawable.fight,
                "MMA","SPORTS","5"
        ));
         main_recycler=(RecyclerView)view.findViewById(R.id.rec_videos);
        initnextrecycler();
        return view;
    }
    private void initnextrecycler()
    {
        //RecyclerView main_recycler=(RecyclerView)findViewById(R.id.next_rec);
        GridLayoutManager main_layoutmanger=new GridLayoutManager(getActivity(),1);
        main_recycler.setLayoutManager(main_layoutmanger);
        main_recycler.setHasFixedSize(true);
        Chanels_channel_Adapter Main_adapter=new Chanels_channel_Adapter(arrylist_video,getActivity(),spinner_array);
        main_recycler.setAdapter(Main_adapter);

    }
}
