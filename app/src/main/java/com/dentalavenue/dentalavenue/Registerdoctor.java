package com.dentalavenue.dentalavenue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dentalavenue.dentalavenue.registerDoctorPOJO.registerDoctorBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Registerdoctor extends AppCompatActivity {

    EditText userName , email , mobile , password , retype , register;
    Button create;
    ProgressBar progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerdoctor);
        userName = (EditText)findViewById(R.id.username);
        email = (EditText)findViewById(R.id.email);
        register = (EditText) findViewById(R.id.register);
        mobile = (EditText)findViewById(R.id.mobile);
        password = (EditText)findViewById(R.id.password);
        retype = (EditText)findViewById(R.id.retype);
        create = (Button)findViewById(R.id.create);

        progress = (ProgressBar)findViewById(R.id.progress);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String user = userName.getText().toString();
                String emai = email.getText().toString();
                String regis = register.getText().toString();
                String mob = mobile.getText().toString();
                String pass = password.getText().toString();
                String ret = retype.getText().toString();

                if (user.length()>0)
                {

                    if (emai.length()>0)
                    {

                        if (regis.length()>0)
                        {

                            if (mob.length()>0)
                            {

                                if (pass.length()>0)
                                {

                                    if (ret.length()>0)
                                    {

                                        progress.setVisibility(View.VISIBLE);

                                        Retrofit retrofit = new Retrofit.Builder()
                                                .baseUrl("http://nationproducts.in/")
                                                .addConverterFactory(ScalarsConverterFactory.create())
                                                .addConverterFactory(GsonConverterFactory.create())
                                                .build();

                                        AllAPIs cr = retrofit.create(AllAPIs.class);

                                        Call<registerDoctorBean> call = cr.registerDoctor(user , "" , emai , mob , pass , "doctor" , regis);

                                        call.enqueue(new Callback<registerDoctorBean>() {
                                            @Override
                                            public void onResponse(Call<registerDoctorBean> call, Response<registerDoctorBean> response) {

                                                progress.setVisibility(View.GONE);

                                                Toast.makeText(Registerdoctor.this , response.body().getRegisterDoctor().get(0).getMessage() , Toast.LENGTH_SHORT).show();
                                                finish();

                                            }

                                            @Override
                                            public void onFailure(Call<registerDoctorBean> call, Throwable throwable) {
                                                progress.setVisibility(View.GONE);
                                            }
                                        });

                                    }
                                    else
                                    {
                                        Toast.makeText(Registerdoctor.this , "Password did not match" , Toast.LENGTH_SHORT).show();
                                    }

                                }
                                else
                                {
                                    Toast.makeText(Registerdoctor.this , "Invalid Password" , Toast.LENGTH_SHORT).show();
                                }

                            }
                            else
                            {
                                Toast.makeText(Registerdoctor.this , "Invalid Mobile Number" , Toast.LENGTH_SHORT).show();
                            }

                        }
                        else
                        {
                            Toast.makeText(Registerdoctor.this , "Invalid Registration Number" , Toast.LENGTH_SHORT).show();
                        }

                    }
                    else
                    {
                        Toast.makeText(Registerdoctor.this , "Invalid Email" , Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Toast.makeText(Registerdoctor.this , "Invalid Username" , Toast.LENGTH_SHORT).show();
                }






            }
        });

    }
}

