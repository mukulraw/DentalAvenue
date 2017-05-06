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
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;


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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.single_layout, container, false);

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
