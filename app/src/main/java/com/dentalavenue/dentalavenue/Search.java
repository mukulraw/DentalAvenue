package com.dentalavenue.dentalavenue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.dentalavenue.dentalavenue.OfferPOJO.OfferBeann;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Search extends AppCompatActivity {


    EditText editText;
    RecyclerView recycler;
    GridLayoutManager manager;
    SearchAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        editText = (EditText) findViewById(R.id.edit);
        recycler = (RecyclerView) findViewById(R.id.recycler);


        manager = new GridLayoutManager(Search.this, 2);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);


    }
}
