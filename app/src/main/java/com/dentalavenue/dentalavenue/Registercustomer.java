package com.dentalavenue.dentalavenue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.dentalavenue.dentalavenue.RegisterPOJO.registerBean;
import com.dentalavenue.dentalavenue.cityPOJO.cityBean;
import com.dentalavenue.dentalavenue.countryPOJO.countryBean;
import com.dentalavenue.dentalavenue.statePOJO.stateBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Registercustomer extends AppCompatActivity {

    EditText dealer,company,cinno,vatno,complete,contact,email;
    Button create;
    ProgressBar progress;
    Spinner country , state , city;

    List<String> countryName , countryId , stateName , stateId , cityName , cityId;

    String countr = "" , stat = "" , cit = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registercustomer);

        countryName = new ArrayList<>();
        countryId = new ArrayList<>();
        stateName = new ArrayList<>();
        stateId = new ArrayList<>();
        cityName = new ArrayList<>();
        cityId = new ArrayList<>();

        dealer = (EditText)findViewById(R.id.dealer);
        company = (EditText)findViewById(R.id.company);
        email = (EditText)findViewById(R.id.email);
        cinno = (EditText)findViewById(R.id.cinno);
        vatno = (EditText)findViewById(R.id.vatno);
        complete = (EditText)findViewById(R.id.complete);
        contact = (EditText)findViewById(R.id.contact);
        create = (Button)findViewById(R.id.create);
        progress = (ProgressBar)findViewById(R.id.progress);
        country = (Spinner)findViewById(R.id.country);
        state = (Spinner)findViewById(R.id.state);
        city = (Spinner)findViewById(R.id.city);


        progress.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nationproducts.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final AllAPIs cr = retrofit.create(AllAPIs.class);


        Call<countryBean> call = cr.getCountries();

        call.enqueue(new Callback<countryBean>() {
            @Override
            public void onResponse(Call<countryBean> call, Response<countryBean> response) {

                countryName = new ArrayList<>();
                countryName.add(" --- Select country --- ");
                for (int i = 0 ; i < response.body().getCountry().size() ; i++)
                {
                    countryName.add(response.body().getCountry().get(i).getCountryName());
                    countryId.add(response.body().getCountry().get(i).getCountryId());
                }

                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Registercustomer.this , R.layout.spinner_model , countryName);
                country.setAdapter(adapter1);

                progress.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<countryBean> call, Throwable t) {
                progress.setVisibility(View.GONE);
            }
        });


        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position>0)
                {

                    progress.setVisibility(View.VISIBLE);

                    Call<stateBean> call = cr.getState(countryId.get(position-1));

                    call.enqueue(new Callback<stateBean>() {
                        @Override
                        public void onResponse(Call<stateBean> call, Response<stateBean> response) {

                            stateName = new ArrayList<>();
                            stateId = new ArrayList<>();

                            stateName.add(" --- Select State --- ");

                            for (int i = 0 ; i < response.body().getState().size() ; i++)
                            {
                                stateName.add(response.body().getState().get(i).getStateName());
                                stateId.add(response.body().getState().get(i).getStateId());
                            }

                            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Registercustomer.this , R.layout.spinner_model , stateName);
                            state.setAdapter(adapter1);

                            progress.setVisibility(View.GONE);

                        }

                        @Override
                        public void onFailure(Call<stateBean> call, Throwable t) {
                            progress.setVisibility(View.GONE);
                        }
                    });

                }
                else
                {
                    countr = "";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position>0)
                {
                    progress.setVisibility(View.VISIBLE);

                    Call<cityBean> call = cr.getCity(stateId.get(position-1));

                    call.enqueue(new Callback<cityBean>() {
                        @Override
                        public void onResponse(Call<cityBean> call, Response<cityBean> response) {

                            cityName = new ArrayList<>();
                            cityId = new ArrayList<>();

                            cityName.add(" --- Select City --- ");

                            for (int i = 0 ; i < response.body().getCity().size() ; i++)
                            {
                                cityName.add(response.body().getCity().get(i).getCityName());
                                cityId.add(response.body().getCity().get(i).getCityId());
                            }

                            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Registercustomer.this , R.layout.spinner_model , cityName);
                            city.setAdapter(adapter1);

                            progress.setVisibility(View.GONE);

                        }

                        @Override
                        public void onFailure(Call<cityBean> call, Throwable t) {
                            progress.setVisibility(View.GONE);
                        }
                    });

                }
                else
                {
                    countr = "";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress.setVisibility(View.VISIBLE);



                /*Call<registerBean> call = cr.register(dealer.getText().toString() , "" , email.getText().toString() , cinno.getText().toString() , vatno.getText().toString() , "customer");

                call.enqueue(new Callback<registerBean>() {
                    @Override
                    public void onResponse(Call<registerBean> call, Response<registerBean> response) {
                        progress.setVisibility(View.GONE);
                        Toast.makeText(Registercustomer.this , response.body().getRegister().get(0).getMessage() , Toast.LENGTH_SHORT).show();
                        finish();

                    }

                    @Override
                    public void onFailure(Call<registerBean> call, Throwable throwable) {
                        progress.setVisibility(View.GONE);
                    }
                });
*/


            }
        });

    }
}
