package com.dentalavenue.dentalavenue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Homepage extends AppCompatActivity {

    ImageView da , ang , dia , dmg , major , sdi , ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        da = (ImageView)findViewById(R.id.da);
        ang = (ImageView)findViewById(R.id.ang);
        dia = (ImageView)findViewById(R.id.dia);
        dmg = (ImageView)findViewById(R.id.dmg);
        major = (ImageView)findViewById(R.id.major);
        sdi = (ImageView)findViewById(R.id.sdi);
        ss = (ImageView)findViewById(R.id.ss);

        da.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Homepage.this , MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
