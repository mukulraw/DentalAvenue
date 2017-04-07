package com.dentalavenue.dentalavenue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Docterlogin extends AppCompatActivity {
    TextView facebook,google,create,forgot;
    EditText email,password;
    Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docterlogin);
        facebook = (TextView) findViewById(R.id.facebook);
        google = (TextView) findViewById(R.id.google);
        create = (TextView) findViewById(R.id.create);
        forgot = (TextView) findViewById(R.id.forgot);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        sign = (Button) findViewById(R.id.sign);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Docterlogin.this, Registerdoctor.class);
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

                Call<loginBean> call = cr.login(email.getText().toString() , password.getText().toString() , "doctor");

                call.enqueue(new Callback<loginBean>() {
                    @Override
                    public void onResponse(Call<loginBean> call, Response<loginBean> response) {

                        if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Username And Password Invalid."))
                        {
                            Toast.makeText(Docterlogin.this , "Invalid details" , Toast.LENGTH_SHORT).show();
                        }
                        else if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Login Successfull."))
                        {
                            Intent intent = new Intent(Docterlogin.this , Homepage.class);
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
