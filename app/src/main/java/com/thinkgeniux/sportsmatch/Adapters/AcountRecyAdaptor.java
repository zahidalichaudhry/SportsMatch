package com.thinkgeniux.sportsmatch.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thinkgeniux.sportsmatch.PojoClasses.AccountPojo;
import com.thinkgeniux.sportsmatch.R;

import java.util.ArrayList;

/**
 * Created by Fakhar Ali on 2/1/2019.
 */

public class AcountRecyAdaptor extends RecyclerView.Adapter<AcountRecyAdaptor.ProgrammingViewHolder> {

    ArrayList<AccountPojo> arrayList;
    Context context;

    public AcountRecyAdaptor(ArrayList<AccountPojo> arrayList, Context context) {
        this.arrayList=arrayList;
        this.context=context;
    }

    @Override
    public ProgrammingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.accountlist,parent,false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgrammingViewHolder holder, int position) {
        int imagesarray=arrayList.get(position).getImages();
        String txttitles=arrayList.get(position).getTitle();
        String txtsubtitles=arrayList.get(position).getSubtitle();

        holder.imageView.setImageResource(imagesarray);
        holder.title.setText(txttitles);
        holder.subtitle.setText(txtsubtitles);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView subtitle;
        public ProgrammingViewHolder(View itemView) {
            super(itemView);

            imageView=(ImageView) itemView.findViewById(R.id.image);
            title=(TextView) itemView.findViewById(R.id.title);
            subtitle=(TextView) itemView.findViewById(R.id.subtitle);


        }
    }
}
