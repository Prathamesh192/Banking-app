package com.example.tsf_bank;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Recycleadapter1 extends RecyclerView.Adapter<Recycleadapter1.ItemviewHolder> {
    //private ArrayList<Itemsincard> itemList;
    List<MemberImport> storemem ;
    Context context;
    DbSupport dbSupport;

    public Recycleadapter1(List<MemberImport> storemem,Context context){
        this.storemem = storemem;
        this.context = context;
        dbSupport = new DbSupport(context);

    }


    public static class ItemviewHolder extends RecyclerView.ViewHolder{
        //public ImageView myimage;
        public TextView mytextview1;
        public TextView mytextview2;
        public ItemviewHolder(View itemView){
            super(itemView);
            //myimage = itemView.findViewById(R.id.image1);
            mytextview1 = itemView.findViewById(R.id.textline1);
            mytextview2 = itemView.findViewById(R.id.textline2);

        }

    }



    @NonNull
    @Override
    public ItemviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards,parent,false);
        ItemviewHolder ivh = new ItemviewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemviewHolder holder, int position) {
        // Itemsincard currentitem = itemList.get(position);
        final MemberImport temp = storemem.get(position);
        //  holder.myimage.setImageResource(currentitem.getImageres());
        holder.mytextview1.setText(storemem.get(position).getName());
        holder.mytextview2.setText(storemem.get(position).getAccountNo());

        holder.mytextview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,RecieverInfo.class);

                i.putExtra("Id",storemem.get(position).getId());
                i.putExtra("Name",storemem.get(position).getName());
                i.putExtra("Email",storemem.get(position).getEmail());
                i.putExtra("Current",storemem.get(position).getCurrentbal());
                i.putExtra("Accno",storemem.get(position).getAccountNo());
                i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);


            }
        });
    }

    @Override
    public int getItemCount() {
        return storemem.size();
    }
}


