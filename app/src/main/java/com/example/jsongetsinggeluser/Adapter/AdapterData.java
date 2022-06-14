package com.example.jsongetsinggeluser.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsongetsinggeluser.Model.Data;
import com.example.jsongetsinggeluser.Model.Support;
import com.example.jsongetsinggeluser.R;
import com.squareup.picasso.Picasso;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderView> {
    Context context;
    Data dataList;
    Support support;

    public AdapterData(Context context,Data dataList,Support support){
        this.dataList = dataList;
        this.context = context;
        this.support = support;
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false);
        HolderView viewHolder = new HolderView(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderView holder, int position) {

        holder.tv_id.setText(String.valueOf(dataList.getId()));
        holder.tv_email.setText(dataList.getEmail());
        holder.tv_first.setText(dataList.getFirstName());
        holder.tv_last.setText(dataList.getLastName());
        Picasso.get().load(dataList.getAvatar()).into(holder.imageView);
        holder.tv_url.setText(support.getUrl());
        holder.tv_Text.setText(support.getText());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class HolderView extends RecyclerView.ViewHolder{
        TextView tv_id,tv_email,tv_first,tv_last,tv_url,tv_Text;
        ImageView imageView;
        public HolderView(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tvId);
            tv_email= itemView.findViewById(R.id.tvEmail);
            tv_first = itemView.findViewById(R.id.tvFirst);
            tv_last = itemView.findViewById(R.id.tvLast);
            imageView = itemView.findViewById(R.id.imgData);
            tv_url = itemView.findViewById(R.id.tvUrl);
            tv_Text = itemView.findViewById(R.id.tvText);
        }
    }
}