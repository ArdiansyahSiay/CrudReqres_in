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

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderView> {
    Context context;
    List<Data>  dataList;
    List<Support> supportList;
    public AdapterData(Context context,List<Data> dataList,List<Support> supportList){
        this.context = context;
        this.dataList = dataList;
        this.supportList=supportList;
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false);
        HolderView holderView = new HolderView(view);
        return  holderView;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderView holder, int position) {
        Data dt =  dataList.get(position);
        Support sp = supportList.get(position);

    }

    @Override
    public int getItemCount() {
        return dataList.size()+supportList.size();
    }

    public class HolderView extends RecyclerView.ViewHolder{
        TextView tv_id,tv_firs,tv_last,tv_email;
        ImageView img_data;

        public HolderView(@NonNull View itemView) {
            super(itemView);
        }
    }
}
