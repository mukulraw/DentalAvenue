package com.dentalavenue.dentalavenue;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dentalavenue.dentalavenue.loginPOJO.loginBean;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Cutomerlogin extends AppCompatActivity {
    TextView facebook,google,create,forgot;
    EditText email,password;
    Button sign;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutomerlogin);

        facebook = (TextView) findViewById(R.id.facebook);
        google = (TextView) findViewById(R.id.google);
        create = (TextView) findViewById(R.id.create);
        forgot = (TextView) findViewById(R.id.forgot);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        sign = (Button) findViewById(R.id.sign);

        toolbar = (Toolbar)findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setTitle("Sign in");
        toolbar.setTitleTextColor(Color.WHITE);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cutomerlogin.this,Registercustomer.class);
                startActivity(intent);
            }
        });


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://nationproducts.in/")
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                AllAPIs cr = retrofit.create(AllAPIs.class);

                Call<loginBean> call = cr.login(email.getText().toString() , password.getText().toString() , "customer");

                call.enqueue(new Callback<loginBean>() {
                    @Override
                    public void onResponse(Call<loginBean> call, Response<loginBean> response) {

                        if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Username And Password Invalid."))
                        {
                            Toast.makeText(Cutomerlogin.this , "Invalid details" , Toast.LENGTH_SHORT).show();
                        }
                        else if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Login Successfull."))
                        {
                            Intent intent = new Intent(Cutomerlogin.this , Homepage.class);
                            startActivity(intent);
                            finish();
                        }

                    }

                    @Override
                    public void onFailure(Call<loginBean> call, Throwable throwable) {

                    }
                });



            }
        });


    }
}
