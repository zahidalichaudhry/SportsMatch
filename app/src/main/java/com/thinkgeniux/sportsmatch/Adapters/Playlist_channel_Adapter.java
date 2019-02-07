package com.thinkgeniux.sportsmatch.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.thinkgeniux.sportsmatch.Activities.Videoplayer;
import com.thinkgeniux.sportsmatch.PojoClasses.Main_Video_Pojo;
import com.thinkgeniux.sportsmatch.R;

import java.util.ArrayList;


/**
 * Created by CH-Hamza on 2/21/2018.
 */




public class Playlist_channel_Adapter extends RecyclerView.Adapter<Playlist_channel_Adapter.MyViewHolder> {
    Activity activity;
    ArrayList<Main_Video_Pojo> arrayList=new ArrayList<>();
    String [] spinner_arry=new String[6];
    String spinner_selected;
    public Playlist_channel_Adapter(ArrayList<Main_Video_Pojo> arrayList, Context context, String [] spinner_arry) {
        this.arrayList=arrayList;
        this.spinner_arry=spinner_arry;
        activity = (Activity) context;
    }

    @Override
    public Playlist_channel_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_video_item, parent, false);
        return new Playlist_channel_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final Playlist_channel_Adapter.MyViewHolder holder, final int position)
    {
        holder.video_name.setText(arrayList.get(position).getVideo_name());
        holder.video_detials.setText(arrayList.get(position).getVideo_details());
        holder.video_length.setText(arrayList.get(position).getVideo_lenth());
//                holder.imageView.setImageResource(icons[position]);
        holder.video_img.setImageResource(arrayList.get(position).getVideo_url());
        holder.video_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(activity, Videoplayer.class);
                intent.putExtra("id",arrayList.get(position).getId());
                activity.startActivity(intent);
            }
        });

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (activity, android.R.layout.simple_spinner_item,
                        spinner_arry);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        holder.spinner_options.setAdapter(spinnerArrayAdapter);

        holder.spinner_options.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView video_name,video_detials,video_length,tv_views;
        ImageView video_img;
        Spinner spinner_options;


        public MyViewHolder(View itemView) {
            super(itemView);
//            imageView = (ImageView) itemView.findViewById(R.id.product_pic);
//            remove=(FloatingActionButton)itemView.findViewById(R.id.floatingremove);
            video_img = (ImageView) itemView.findViewById(R.id.product_pic);
            video_name=(TextView)itemView.findViewById(R.id.name);
            video_detials=(TextView)itemView.findViewById(R.id.tv_details);
            video_length=(TextView)itemView.findViewById(R.id.tv_length);
            tv_views=(TextView)itemView.findViewById(R.id.tv_views);
            spinner_options=(Spinner)itemView.findViewById(R.id.spinner_options);

        }

    }
}


