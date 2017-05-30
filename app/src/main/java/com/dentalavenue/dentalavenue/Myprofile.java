package com.dentalavenue.dentalavenue;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dentalavenue.dentalavenue.categoryPOJO.categoryBean;
import com.dentalavenue.dentalavenue.changePassPOJO.ChangePass;
import com.dentalavenue.dentalavenue.changePassPOJO.PassChange;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class Myprofile extends AppCompatActivity {
    ImageView imageview;
    TextView name, email, phone, organization, qualification, address, address2, password, edit;

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
                Intent intent = new Intent(Myprofile.this, Edit.class);
                startActivity(intent);
            }
        });


        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(Myprofile.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.change_pass_dialog);
                dialog.setCancelable(false);
                dialog.show();

                TextView change = (TextView) dialog.findViewById(R.id.submit);
                final ProgressBar progressBar = (ProgressBar) dialog.findViewById(R.id.progress);
                final EditText old_pass, new_pass;
                old_pass = (EditText) dialog.findViewById(R.id.old_pass);
                new_pass = (EditText) dialog.findViewById(R.id.new_pass);

                change.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        progressBar.setVisibility(View.VISIBLE);

                        String old_pas, new_pas;
                        old_pas=old_pass.getText().toString().trim();
                        new_pas=new_pass.getText().toString().trim();

                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://nationproducts.in/")
                                .addConverterFactory(ScalarsConverterFactory.create())
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

                        AllAPIs cr = retrofit.create(AllAPIs.class);
                        bean b = (bean)getApplicationContext();
                        String id=b.userId.toString();

                        Call<ChangePass> call = cr.changePass(old_pas, new_pas, id);

                        call.enqueue(new Callback<ChangePass>() {
                            @Override
                            public void onResponse(Call<ChangePass> call, Response<ChangePass> response) {

                                Toast.makeText(Myprofile.this,response.body().getPassChange().get(0).getMessage(),Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                dialog.dismiss();
                            }


                            @Override
                            public void onFailure(Call<ChangePass> call, Throwable throwable) {


                            }
                        });


                    }
                });


            }
        });
    }
}
