package com.dentalavenue.dentalavenue;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Myprofile extends AppCompatActivity {
    ImageView imageview;
TextView name,email,phone,organization,qualification,address,address2,password,edit;

Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        imageview = (ImageView) findViewById(R.id.image);
        name = (TextView) findViewById(R.id.surname);
        email = (TextView) findViewById(R.id.email);
        phone = (TextView) findViewById(R.id.ph_no);
        organization = (TextView) findViewById(R.id.orgnization);
        qualification = (TextView) findViewById(R.id.qualification);
        address = (TextView) findViewById(R.id.address);
        address2 = (TextView) findViewById(R.id.address_2);
        edit = (TextView) findViewById(R.id.edit);

        password = (TextView) findViewById(R.id.change);


        toolbar = (Toolbar) findViewById(R.id.bar);
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

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Myprofile.this,Edit.class);
                startActivity(intent);
            }
        });
    }
}
