package com.example.recyclerfilterapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewHolder>{
    private List<String> list;
    private Context context;

    public RecyclerAdapter(List<String> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(textView,context,list);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
        Context context;
        List<String>list;
        public MyViewHolder(@NonNull TextView itemView,Context context,List<String>list) {
            super(itemView);
            textView = itemView;
            this.context = context;
            this.list = list;
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int p = getAdapterPosition();
            Intent intent = new Intent(context,ItemActivity.class);
            intent.putExtra("id",p);
            intent.putExtra("itemName",list.get(p));
            context.startActivity(intent);
        }
    }

    public void updateList(List<String> newList){
        list = new ArrayList<>();
        list.addAll(newList);
        notifyDataSetChanged();
    }
}

