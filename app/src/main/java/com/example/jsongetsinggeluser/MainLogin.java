package com.example.jsongetsinggeluser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jsongetsinggeluser.APILogin.APILogin;
import com.example.jsongetsinggeluser.APILogin.ConectLogin;
import com.example.jsongetsinggeluser.ModelLogin.RequestModel;
import com.example.jsongetsinggeluser.ModelLogin.ResponRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainLogin extends AppCompatActivity {

    EditText et_email, et_pass;
    Button bt_login;
    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        et_email = findViewById(R.id.etEmailLogin);
        et_pass = findViewById(R.id.etPassLogin);
        bt_login = findViewById(R.id.btLogin);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = et_email.getText().toString();
                password = et_pass.getText().toString();
                requestIn();

//                if (email.isEmpty()){
//                    et_email.setError("Email Tidak Boleh Kosong");
//
//                }else if (password.isEmpty()){
//                    et_pass.setError("Password Tidak Boleh Kosong");
//                }
//                else{
//                    requestIn();
//                }
            }
        });
    }
    public void requestIn(){
        RequestModel requestModel = new RequestModel();
        requestModel.setEmail(et_email.getText().toString());
        requestModel.setPassword(et_pass.getText().toString());
        APILogin apiLogin = ConectLogin.getServisRetro().create(APILogin.class);
        Call<ResponRequest> responRequestCall = apiLogin.loginRequest(requestModel);

        responRequestCall.enqueue(new Callback<ResponRequest>() {
            @Override
            public void onResponse(Call<ResponRequest> call, Response<ResponRequest> response) {
                try {
                    if (response.code()==200){
                        startActivity(new Intent(MainLogin.this,MainActivity.class));

                    }else {
                        Toast.makeText(MainLogin.this, "Pesan: "+response.errorBody().string(), Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            @Override
            public void onFailure(Call<ResponRequest> call, Throwable t) {
                Toast.makeText(MainLogin.this, "Gagal Keserver"+t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

}