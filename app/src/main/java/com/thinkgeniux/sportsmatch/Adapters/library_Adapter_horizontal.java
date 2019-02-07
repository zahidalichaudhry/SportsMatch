package com.thinkgeniux.sportsmatch.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
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
import com.thinkgeniux.sportsmatch.PojoClasses.Stories;
import com.thinkgeniux.sportsmatch.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by CH-Hamza on 2/21/2018.
 */




public class library_Adapter_horizontal extends RecyclerView.Adapter<library_Adapter_horizontal.MyViewHolder> {
    Activity activity;
    ArrayList<Main_Video_Pojo> arrayList=new ArrayList<>();
    String [] spinner_arry=new String[6];
    String spinner_selected;
    public library_Adapter_horizontal(ArrayList<Main_Video_Pojo> arrayList, Context context, String [] spinner_arry) {
        this.arrayList=arrayList;
        activity = (Activity) context;
        this.spinner_arry=spinner_arry;
    }

    @Override
    public library_Adapter_horizontal.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.library_horizontal_item, parent, false);
        return new library_Adapter_horizontal.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final library_Adapter_horizontal.MyViewHolder holder, final int position)
    {
        holder.name.setText(arrayList.get(position).getVideo_name());
        holder.imageView.setImageResource(arrayList.get(position).getVideo_url());

        holder.video_detials.setText(arrayList.get(position).getVideo_details());
        holder.video_length.setText(arrayList.get(position).getVideo_lenth());
//                holder.imageView.setImageResource(icons[position]);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
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
        TextView name,video_detials,video_length;
        ImageView imageView;
        Spinner spinner_options;

        public MyViewHolder(View itemView) {
            super(itemView);
//            imageView = (ImageView) itemView.findViewById(R.id.product_pic);
//            remove=(FloatingActionButton)itemView.findViewById(R.id.floatingremove);
            imageView = (ImageView) itemView.findViewById(R.id.product_pic);
            name=(TextView)itemView.findViewById(R.id.name);
            spinner_options=(Spinner)itemView.findViewById(R.id.spinner_options);
            video_length=(TextView)itemView.findViewById(R.id.tv_length);
            video_detials=(TextView)itemView.findViewById(R.id.tv_details);

        }

    }
}


