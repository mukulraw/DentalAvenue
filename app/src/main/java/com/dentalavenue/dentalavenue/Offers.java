package com.dentalavenue.dentalavenue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.dentalavenue.dentalavenue.OfferPOJO.Offer;
import com.dentalavenue.dentalavenue.OfferPOJO.OfferBeann;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Offers extends AppCompatActivity {
    RecyclerView recycler;
    GridLayoutManager manager;
    OfferAdapter adapter;

    ProgressBar progress;

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        progress = (ProgressBar) findViewById(R.id.progress);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        manager = new GridLayoutManager(Offers.this,   2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        progress.setVisibility(View.VISIBLE);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nationproducts.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AllAPIs cr = retrofit.create(AllAPIs.class);


        Call<OfferBeann> call = cr.getCOffers();

        call.enqueue(new Callback<OfferBeann>() {
            @Override
            public void onResponse(Call<OfferBeann> call, Response<OfferBeann> response) {

                List<Offer> list = response.body().getOffer();
                adapter = new OfferAdapter(Offers.this , list);

                recycler.setLayoutManager(manager);
                recycler.setAdapter(adapter);

                progress.setVisibility(View.GONE);





            }

            @Override
            public void onFailure(Call<OfferBeann> call, Throwable t) {
                 progress.setVisibility(View.GONE);

            }
        });


    }
}
