package com.example.jsongetsinggeluser.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsongetsinggeluser.Model.Data;
import com.example.jsongetsinggeluser.Model.Support;

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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HolderView extends RecyclerView.ViewHolder{

        public HolderView(@NonNull View itemView) {
            super(itemView);
        }
    }
}
