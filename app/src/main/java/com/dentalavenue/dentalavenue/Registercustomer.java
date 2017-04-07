package com.dentalavenue.dentalavenue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dentalavenue.dentalavenue.RegisterPOJO.registerBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Registercustomer extends AppCompatActivity {

    EditText userName , email , mobile , password , retype;
    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registercustomer);

        userName = (EditText)findViewById(R.id.username);
        email = (EditText)findViewById(R.id.email);
        mobile = (EditText)findViewById(R.id.mobile);
        password = (EditText)findViewById(R.id.password);
        retype = (EditText)findViewById(R.id.retype);
        create = (Button)findViewById(R.id.create);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://nationproducts.in/")
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                AllAPIs cr = retrofit.create(AllAPIs.class);

                Call<registerBean> call = cr.register(userName.getText().toString() , "" , email.getText().toString() , mobile.getText().toString() , password.getText().toString() , "customer");

                call.enqueue(new Callback<registerBean>() {
                    @Override
                    public void onResponse(Call<registerBean> call, Response<registerBean> response) {

                        Toast.makeText(Registercustomer.this , response.body().getRegister().get(0).getMessage() , Toast.LENGTH_SHORT).show();
                        finish();

                    }

                    @Override
                    public void onFailure(Call<registerBean> call, Throwable throwable) {

                    }
                });



            }
        });

    }
}
