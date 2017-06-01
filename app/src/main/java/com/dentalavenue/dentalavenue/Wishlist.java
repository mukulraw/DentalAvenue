package com.dentalavenue.dentalavenue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.dentalavenue.dentalavenue.viewCartPOJO.viewCartBean;
import com.dentalavenue.dentalavenue.viewWishlistPOJO.WishlishtDetailsBean;
import com.dentalavenue.dentalavenue.viewWishlistPOJO.WishlistDetail;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class Wishlist extends AppCompatActivity {


    Toolbar toolbar;
    RecyclerView recycler;
    ProgressBar progress;
    List<WishlistDetail> list;
    GridLayoutManager manager;
    Wishadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wishlist);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recycler = (RecyclerView) findViewById(R.id.recycler);

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

        progress = (ProgressBar)findViewById(R.id.progress);
        list = new ArrayList<>();

        Wishadapter wishadapter = new Wishadapter(Wishlist.this, list);
        manager = new GridLayoutManager(Wishlist.this , 1);



        recycler.setLayoutManager(manager);
        recycler.setAdapter(wishadapter);



        adapter = new Wishadapter(this , list);

        recycler.setAdapter(adapter);
        recycler.setLayoutManager(manager);

    }

    @Override
    protected void onResume() {
        super.onResume();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nationproducts.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AllAPIs cr = retrofit.create(AllAPIs.class);

        bean b = (bean)getApplicationContext();

        Call<WishlishtDetailsBean> call = cr.wishlist_details(b.userId);
        Log.d("sdsaasa",b.userId);


        call.enqueue(new Callback<WishlishtDetailsBean>() {
            @Override
            public void onResponse(Call<WishlishtDetailsBean> call, Response<WishlishtDetailsBean> response) {
                progress.setVisibility(View.VISIBLE);
                list = response.body().getWishlistDetail();



                adapter.setGridData(list);

                progress.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<WishlishtDetailsBean> call, Throwable throwable) {
                progress.setVisibility(View.GONE);
            }
        });


    }
}
