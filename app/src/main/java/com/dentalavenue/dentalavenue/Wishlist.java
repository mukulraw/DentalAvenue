package com.dentalavenue.dentalavenue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class Wishlist extends AppCompatActivity {

Toolbar toolbar;
    RecyclerView recycler;
    GridLayoutManager manager;


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

        Wishadapter wishadapter = new Wishadapter(Wishlist.this);
        manager = new GridLayoutManager(Wishlist.this , 1);

        recycler.setLayoutManager(manager);
        recycler.setAdapter(wishadapter);


    }
}
