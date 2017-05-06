package com.dentalavenue.dentalavenue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.dentalavenue.dentalavenue.singleProductPOJO.singleProductBean;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class Singleproduct extends Fragment {

    ImageView image;
    TextView minus,plus;
    TextView price;
    TextView number;
    Button cart;
    TextView name;
    RatingBar rating;
    TextView wishlist;
    TextView category;
    TextView stock;
    TextView code;
    TextView features;
    TextView description;
    String id;
    Spinner spinner;
    List<String> skuId , skuCode;
    List<String> priceId , pricePrice;
    List<String> doctorSpId , doctorSpPrice;
    List<String> dealerSpId , dealerSpPrice;
    List<String> qtyId , qtyQty;
    List<String> sizeId , sizePrice;
    List<String> offerDoctorId , offerDoctorPrice;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.single_layout, container, false);

        skuId = new ArrayList<>();
        skuCode = new ArrayList<>();
        priceId = new ArrayList<>();
        pricePrice = new ArrayList<>();
        doctorSpId = new ArrayList<>();
        doctorSpPrice = new ArrayList<>();
        dealerSpId = new ArrayList<>();
        dealerSpPrice = new ArrayList<>();
        qtyId = new ArrayList<>();
        qtyQty = new ArrayList<>();
        sizeId = new ArrayList<>();
        sizePrice = new ArrayList<>();
        offerDoctorId = new ArrayList<>();
        offerDoctorPrice = new ArrayList<>();



        image = (ImageView) view.findViewById(R.id.imageView);

        minus = (TextView) view.findViewById(R.id.minus);
        plus = (TextView) view.findViewById(R.id.plus);
        price = (TextView)view.findViewById(R.id.price);
        number = (TextView)view.findViewById(R.id.number);
        cart = (Button)view.findViewById(R.id.cart);
        name = (TextView)view.findViewById(R.id.name);
        rating = (RatingBar)view.findViewById(R.id.rating);
        wishlist = (TextView)view.findViewById(R.id.wishlist);
        category = (TextView)view.findViewById(R.id.category);
        stock = (TextView)view.findViewById(R.id.stock);
        code = (TextView)view.findViewById(R.id.code);
        features = (TextView)view.findViewById(R.id.features);
        description = (TextView)view.findViewById(R.id.description);
        spinner = (Spinner)view.findViewById(R.id.spinner);


        id = getArguments().getString("id");





        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nationproducts.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AllAPIs cr = retrofit.create(AllAPIs.class);

        Call<singleProductBean> call = cr.getProductDetails(id);


        call.enqueue(new Callback<singleProductBean>() {
            @Override
            public void onResponse(Call<singleProductBean> call, Response<singleProductBean> response) {

                bean b = (bean)getContext().getApplicationContext();

                if (b.type == "doctor")
                {

                    price.setText(response.body().getProductDetail().get(0).getSalePriceToDoctor().get(0).getPrice());

                }
                else if (b.type == "dealer")
                {

                    price.setText(response.body().getProductDetail().get(0).getSalePriceToDealer().get(0).getPrice());

                }





            }

            @Override
            public void onFailure(Call<singleProductBean> call, Throwable throwable) {

            }
        });





        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = number.getText().toString();
                int n = Integer.parseInt(num);

                if (n>1)
                {
                    n--;
                    number.setText(String.valueOf(n));
                }

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String num = number.getText().toString();
                int n = Integer.parseInt(num);

                    n++;
                    number.setText(String.valueOf(n));

            }
        });



        return view;
    }
}
