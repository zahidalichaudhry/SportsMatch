package com.thinkgeniux.sportsmatch.Adapters;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.thinkgeniux.sportsmatch.PojoClasses.Stories;
import com.thinkgeniux.sportsmatch.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by CH-Hamza on 2/21/2018.
 */




public class Stories_Adapter_horizontal extends RecyclerView.Adapter<Stories_Adapter_horizontal.MyViewHolder> {
    Activity activity;
    ArrayList<Stories> arrayList=new ArrayList<>();
    Dialog dialog;
    ConstraintLayout cl_full;
    String uriString;
    VideoView vv;
    String id;
    MediaController mediaController;
    public Stories_Adapter_horizontal(ArrayList<Stories> arrayList, Context context) {
        this.arrayList=arrayList;
        activity = (Activity) context;
    }

    @Override
    public Stories_Adapter_horizontal.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stories_item, parent, false);
        return new Stories_Adapter_horizontal.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final Stories_Adapter_horizontal.MyViewHolder holder, final int position)
    {
        holder.name.setText(arrayList.get(position).getCategName());
        holder.imageView.setImageResource(arrayList.get(position).getCategImage());
        View view2 = activity.getLayoutInflater().inflate(R.layout.full_screen_dialog,null);
        dialog= new Dialog(activity,android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        dialog.setContentView(view2);
        cl_full=view2.findViewById(R.id.cl_fullscreen);
        vv = view2.findViewById(R.id.main_videoView);
        mediaController =new  MediaController(activity);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                id=arrayList.get(position).getID();
                if (id.equals("1")||id.equals("3"))
                {
                    uriString = "android.resource://" + activity.getPackageName() + "/" + R.raw.bestgoals;
                }else
                {
                    uriString = "android.resource://" + activity.getPackageName() + "/" + R.raw.fight;

                }
                vv.setVideoURI(Uri.parse(uriString));
                vv.setMediaController(mediaController);
                vv.setZOrderOnTop(true);
                vv.start();
                dialog.show();
            }
        });

        vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // dialog.dismiss();
            }
        });

        cl_full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,price;
        FloatingActionButton remove;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
//            imageView = (ImageView) itemView.findViewById(R.id.product_pic);
//            remove=(FloatingActionButton)itemView.findViewById(R.id.floatingremove);
            imageView = (CircleImageView) itemView.findViewById(R.id.circleImageView);
            name=(TextView)itemView.findViewById(R.id.name);

        }

    }
}


