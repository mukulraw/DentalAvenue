package com.dentalavenue.dentalavenue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginType extends AppCompatActivity {

    Button docter,user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_type);
        docter = (Button) findViewById(R.id.docter);
        user = (Button) findViewById(R.id.sales);

        docter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginType.this,Docterlogin.class);
                startActivity(intent);
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginType.this,Cutomerlogin.class);
                startActivity(intent);
            }
        });
    }
}
