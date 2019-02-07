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

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by CH-Hamza on 2/21/2018.
 */




public class Main_library_Adapter extends RecyclerView.Adapter<Main_library_Adapter.MyViewHolder> {
    Activity activity;
    ArrayList<Main_Video_Pojo> arrayList=new ArrayList<>();
    String spinner_selected;
    public Main_library_Adapter(ArrayList<Main_Video_Pojo> arrayList, Context context) {
        this.arrayList=arrayList;

        activity = (Activity) context;
    }

    @Override
    public Main_library_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.library_main_item, parent, false);
        return new Main_library_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final Main_library_Adapter.MyViewHolder holder, final int position)
    {
        holder.video_name.setText(arrayList.get(position).getVideo_name());
        holder.video_detials.setText(arrayList.get(position).getVideo_details());
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
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView video_name,video_detials;
        ImageView video_img;


        public MyViewHolder(View itemView) {
            super(itemView);
            video_img = (ImageView) itemView.findViewById(R.id.img_video);
            video_name=(TextView)itemView.findViewById(R.id.name);
            video_detials=(TextView)itemView.findViewById(R.id.tv_detail);

        }

    }
}


