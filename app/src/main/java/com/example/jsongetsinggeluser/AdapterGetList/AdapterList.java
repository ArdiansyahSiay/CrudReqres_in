package com.example.jsongetsinggeluser.AdapterGetList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsongetsinggeluser.ModelGetList.Datum;
import com.example.jsongetsinggeluser.ModelGetList.Support;
import com.example.jsongetsinggeluser.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.HolderList> {
    Context ctx;
    List<Datum> datumList;
    Support support;
    public AdapterList(Context ctx, List<Datum> datumList,Support support){
        this.ctx = ctx;
        this.datumList =datumList;
        this.support= support;

    }

    @NonNull
    @Override
    public HolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.getl_list_data,parent,false);
        HolderList holderList = new HolderList(view);

        return holderList;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderList holder, int position) {
    Datum data = datumList.get(position);

    holder.tv_nama.setText(data.getName());
    holder.tv_year.setText(String.valueOf(data.getYear()));
    holder.tv_color.setText(data.getColor());
    holder.tv_pantun.setText(data.getPantoneValue());

    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    public class HolderList extends RecyclerView.ViewHolder{
        TextView tv_nama,tv_year,tv_color,tv_pantun;

        public HolderList(@NonNull View itemView) {
            super(itemView);
            tv_nama = itemView.findViewById(R.id.tvNamaList);
            tv_year = itemView.findViewById(R.id.tvYearList);
            tv_color =itemView.findViewById(R.id.tvColorList);
            tv_pantun = itemView.findViewById(R.id.tvPantunList);
        }
    }

}
