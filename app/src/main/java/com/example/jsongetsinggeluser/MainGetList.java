package com.example.jsongetsinggeluser;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsongetsinggeluser.APIgetList.APIgetList;
import com.example.jsongetsinggeluser.APIgetList.RetroConnection;
import com.example.jsongetsinggeluser.AdapterGetList.AdapterList;
import com.example.jsongetsinggeluser.ModelGetList.Datum;
import com.example.jsongetsinggeluser.ModelGetList.RequestModel;
import com.example.jsongetsinggeluser.ModelGetList.Support;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainGetList extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<Datum> datumList;
    Support support;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_get_list);

        recyclerView = findViewById(R.id.rvGetList);
        layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        tampilData();
    }
    public void tampilData(){
        APIgetList apIgetList = RetroConnection.getKoneksi().create(APIgetList.class);
        Call<RequestModel> requestModelCall = apIgetList.dataPick();

        requestModelCall.enqueue(new Callback<RequestModel>() {
            @Override
            public void onResponse(Call<RequestModel> call, Response<RequestModel> response) {
                datumList = response.body().getData();
                adapter = new AdapterList(MainGetList.this,datumList,support);
                recyclerView.setAdapter(adapter);
//                finish();
            }

            @Override
            public void onFailure(Call<RequestModel> call, Throwable t) {
                Toast.makeText(MainGetList.this, "Gagal Keserver", Toast.LENGTH_SHORT).show();
            }
        });
    }
}