package com.dentalavenue.dentalavenue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dentalavenue.dentalavenue.loginPOJO.loginBean;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Splash extends AppCompatActivity {

    SharedPreferences pref;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pref = getSharedPreferences("mypref" , MODE_PRIVATE);

        progress = (ProgressBar)findViewById(R.id.progress);

        if (Objects.equals(pref.getString("type", ""), "doctor"))
        {
            progress.setVisibility(View.VISIBLE);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://nationproducts.in/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            AllAPIs cr = retrofit.create(AllAPIs.class);

            Call<loginBean> call = cr.login(pref.getString("user" , "") , pref.getString("pass" , "") , "doctor");

            call.enqueue(new Callback<loginBean>() {
                @Override
                public void onResponse(Call<loginBean> call, Response<loginBean> response) {

                    Log.d("adsadsa" , response.body().getLogin().get(0).getMessage());

                    if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Username And Password Invalid."))
                    {
                        Toast.makeText(Splash.this , "Invalid details" , Toast.LENGTH_SHORT).show();
                        progress.setVisibility(View.GONE);
                    }
                    else if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Login Successfull."))
                    {
                        progress.setVisibility(View.GONE);

                        bean b = (bean)getApplicationContext();

                        b.name = response.body().getLogin().get(0).getFirstName();
                        b.userId = response.body().getLogin().get(0).getUserId();
                        b.email = response.body().getLogin().get(0).getUserEmail();

                        Intent intent = new Intent(Splash.this , Homepage.class);
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
        else if (Objects.equals(pref.getString("type", ""), "dealer"))
        {
            progress.setVisibility(View.VISIBLE);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://nationproducts.in/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            AllAPIs cr = retrofit.create(AllAPIs.class);

            Call<loginBean> call = cr.login(pref.getString("user" , "") , pref.getString("pass" , "") , "dealer");

            call.enqueue(new Callback<loginBean>() {
                @Override
                public void onResponse(Call<loginBean> call, Response<loginBean> response) {

                    Log.d("adsadsa" , response.body().getLogin().get(0).getMessage());

                    if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Username And Password Invalid."))
                    {
                        Toast.makeText(Splash.this , "Invalid details" , Toast.LENGTH_SHORT).show();
                        progress.setVisibility(View.GONE);
                    }
                    else if (Objects.equals(response.body().getLogin().get(0).getMessage(), "Login Successfull."))
                    {
                        progress.setVisibility(View.GONE);

                        bean b = (bean)getApplicationContext();

                        b.name = response.body().getLogin().get(0).getFirstName();
                        b.userId = response.body().getLogin().get(0).getUserId();
                        b.email = response.body().getLogin().get(0).getUserEmail();

                        Intent intent = new Intent(Splash.this , Homepage.class);
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
            Timer t = new Timer();

            t.schedule(new TimerTask() {
                @Override
                public void run() {

                    Intent intent = new Intent(Splash.this ,LoginType.class);
                    startActivity(intent);
                    finish();
                }
            } , 2000);
        }

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);





    }
}
