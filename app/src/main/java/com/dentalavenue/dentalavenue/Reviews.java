package com.dentalavenue.dentalavenue;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dentalavenue.dentalavenue.AddRatingPOJO.AddRatingBean;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class Reviews extends AppCompatActivity {
    Toolbar toolbar;
    TextView tv_rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        toolbar = (Toolbar) findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setTitle("All Reviews");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_rating = (TextView) findViewById(R.id.tv_rating);

        final String proid = getIntent().getStringExtra("proId");


        tv_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(Reviews.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.rating_dialog);
                final TextView tv_rating = (TextView) dialog.findViewById(R.id.tv_rating);
                RatingBar ratingBar = (RatingBar) dialog.findViewById(R.id.ratingBar);
                TextView submit=(TextView)dialog.findViewById(R.id.submit);

                final String Rate = tv_rating.getText().toString();
                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {


                        tv_rating.setText(String.valueOf(rating));




                    }
                });

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://nationproducts.in/")
                                .addConverterFactory(ScalarsConverterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        AllAPIs cr = retrofit.create(AllAPIs.class);

                        bean b = (bean) getApplicationContext();

                        Call<AddRatingBean> call = cr.Add_rating(b.userId, proid, "", Rate);
                        Log.d("sdsaasa", b.userId);


                        call.enqueue(new Callback<AddRatingBean>() {
                            @Override
                            public void onResponse(Call<AddRatingBean> call, Response<AddRatingBean> response) {

                                Toast.makeText(Reviews.this, response.body().getAddRating().get(0).getMessage(), Toast.LENGTH_SHORT).show();


                            }

                            @Override
                            public void onFailure(Call<AddRatingBean> call, Throwable throwable) {

                            }
                        });

                    }
                });


                dialog.show();

            }
        });

    }
}
