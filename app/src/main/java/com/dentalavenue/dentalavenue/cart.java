package com.dentalavenue.dentalavenue;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.dentalavenue.dentalavenue.viewCartPOJO.CartDatum;
import com.dentalavenue.dentalavenue.viewCartPOJO.viewCartBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class cart extends AppCompatActivity {
    Toolbar toolbar;
    TextView total , checkOut;
    RecyclerView grid;
    GridLayoutManager manager;
    Cartadapter adapter;
    List<CartDatum> list;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        list = new ArrayList<>();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");

        progress = (ProgressBar)findViewById(R.id.progress);

        grid = (RecyclerView)findViewById(R.id.recycler);
        total = (TextView)findViewById(R.id.total);
        checkOut = (TextView)findViewById(R.id.check_out);

        manager = new GridLayoutManager(this , 1);

        adapter = new Cartadapter(this , list);

        grid.setAdapter(adapter);
        grid.setLayoutManager(manager);

    }

    @Override
    protected void onResume() {
        super.onResume();

        progress.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nationproducts.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AllAPIs cr = retrofit.create(AllAPIs.class);

        bean b = (bean)getApplicationContext();

        Call<viewCartBean> call = cr.viewCart(b.userId);
        Log.d("sdsaasa",b.userId);


        call.enqueue(new Callback<viewCartBean>() {
            @Override
            public void onResponse(Call<viewCartBean> call, Response<viewCartBean> response) {

                list = response.body().getCartData();



                adapter.setGridData(list);
                progress.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<viewCartBean> call, Throwable throwable) {
                progress.setVisibility(View.GONE);
            }
        });


    }
}
