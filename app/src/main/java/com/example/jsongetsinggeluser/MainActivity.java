package com.example.jsongetsinggeluser;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsongetsinggeluser.API.APIretrofit;
import com.example.jsongetsinggeluser.API.ConnectRetro;
import com.example.jsongetsinggeluser.Adapter.AdapterData;
import com.example.jsongetsinggeluser.Model.Data;
import com.example.jsongetsinggeluser.Model.ResponseModel;
import com.example.jsongetsinggeluser.Model.Support;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Data dataList;
    Support support;
//    List<Support> supportList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rvData);
        layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        lookData();
    }
    public void lookData(){
        APIretrofit apIretrofit = ConnectRetro.getRetrofitService().create(APIretrofit.class);
        Call<ResponseModel> modelCall = apIretrofit.pickData();

        modelCall.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                dataList = response.body().getData();
                support = response.body().getSupport();
                adapter = new AdapterData(MainActivity.this,dataList,support);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error:"+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}