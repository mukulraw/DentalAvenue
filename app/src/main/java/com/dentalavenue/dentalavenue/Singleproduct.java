package com.dentalavenue.dentalavenue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.dentalavenue.dentalavenue.singleProductPOJO.singleProductBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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



        image = (ImageView) view.findViewById(R.id.image);

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






                DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                        .cacheOnDisc(true).resetViewBeforeLoading(false).build();

                ImageLoader loader = ImageLoader.getInstance();

                loader.displayImage(response.body().getProductDetail().get(0).getProImage() , image , options);

                name.setText(response.body().getProductDetail().get(0).getProName());

                category.setText(response.body().getProductDetail().get(0).getCatName());


                features.setText(Html.fromHtml(response.body().getProductDetail().get(0).getKeyFeatures()));
                description.setText(response.body().getProductDetail().get(0).getProDetail());


                for(int i = 0 ; i < response.body().getProductDetail().get(0).getProSku().size() ; i++)
                {
                    skuId.add(i , response.body().getProductDetail().get(0).getProSku().get(i).getId());
                    skuCode.add(i , response.body().getProductDetail().get(0).getProSku().get(i).getSku());

                    priceId.add(i , response.body().getProductDetail().get(0).getPrice().get(i).getId());
                    pricePrice.add(i , response.body().getProductDetail().get(0).getPrice().get(i).getPrice());

                    doctorSpId.add(i , response.body().getProductDetail().get(0).getSalePriceToDoctor().get(i).getId());
                    doctorSpPrice.add(i , response.body().getProductDetail().get(0).getSalePriceToDoctor().get(i).getPrice());

                    dealerSpId.add(i , response.body().getProductDetail().get(0).getSalePriceToDealer().get(i).getId());
                    dealerSpPrice.add(i , response.body().getProductDetail().get(0).getSalePriceToDealer().get(i).getPrice());

                    qtyId.add(i , response.body().getProductDetail().get(0).getQty().get(i).getId());
                    qtyQty.add(i , response.body().getProductDetail().get(0).getQty().get(i).getProQty());

                    sizeId.add(i , response.body().getProductDetail().get(0).getSizeType().get(i).getId());
                    sizePrice.add(i , response.body().getProductDetail().get(0).getSizeType().get(i).getPrice());

                    offerDoctorId.add(i , response.body().getProductDetail().get(0).getOfferToDoctor().get(i).getId());
                    offerDoctorPrice.add(i , response.body().getProductDetail().get(0).getOfferToDoctor().get(i).getProOffer());

                }


                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext() , R.layout.spinner_model , sizePrice);

                spinner.setAdapter(adapter);

           }

            @Override
            public void onFailure(Call<singleProductBean> call, Throwable throwable) {

            }
        });



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                bean b = (bean)getContext().getApplicationContext();

                stock.setText(qtyQty.get(position));
                code.setText(skuCode.get(position));
                if (Objects.equals(b.type, "doctor"))
                {
                    price.setText("Rs. " + doctorSpPrice.get(position));
                }
                else if (Objects.equals(b.type, "dealer"))
                {
                    price.setText("Rs. " + dealerSpPrice.get(position));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
