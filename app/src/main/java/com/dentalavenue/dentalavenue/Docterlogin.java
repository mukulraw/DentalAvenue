package com.dentalavenue.dentalavenue;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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
    Toolbar toolbar;
    ProgressBar progress;

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
        progress = (ProgressBar)findViewById(R.id.progress);

        toolbar = (Toolbar)findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setTitle("Sign in as a Doctor");
        toolbar.setTitleTextColor(Color.WHITE);

        toolbar.setNavigationIcon(R.drawable.back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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

                String user = email.getText().toString();
                String pass = password.getText().toString();

                if (user.length()>0)
                {

                    if (pass.length()>0)
                    {

                        progress.setVisibility(View.VISIBLE);

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

                                Log.d("adsadsa" , response.body().getLogin().get(0).getMessage());

                                if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Username And Password Invalid."))
                                {
                                    Toast.makeText(Docterlogin.this , "Invalid details" , Toast.LENGTH_SHORT).show();
                                    progress.setVisibility(View.GONE);
                                }
                                else if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Login Successfull."))
                                {
                                    progress.setVisibility(View.GONE);
                                    Intent intent = new Intent(Docterlogin.this , Homepage.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                    finish();
                                }

                            }

                            @Override
                            public void onFailure(Call<loginBean> call, Throwable throwable) {

                                progress.setVisibility(View.GONE);

                            }
                        });

                    }
                    else
                    {
                        //Toast.makeText(Docterlogin.this , "Invalid details" , Toast.LENGTH_SHORT).show();
                        password.setError("Invalid details");
                    }

                }
                else
                {
                    //Toast.makeText(Docterlogin.this , "Invalid details" , Toast.LENGTH_SHORT).show();
                    email.setError("Invalid details");
                }



            }
        });

    }

    }
