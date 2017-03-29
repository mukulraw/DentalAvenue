package com.dentalavenue.dentalavenue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;


public class Singleproduct extends Fragment {

    ImageView image;
    ImageButton minus,plus;
    TextView textView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.single_layout, container, false);

        image = (ImageView) view.findViewById(R.id.imageView);

        minus = (ImageButton) view.findViewById(R.id.minus);
        plus = (ImageButton) view.findViewById(R.id.plus);
        textView = (TextView) view.findViewById(R.id.text);

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = textView.getText().toString();
                int n = Integer.parseInt(num);

                if (n>1)
                {
                    n--;
                    textView.setText(String.valueOf(n));
                }

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String num = textView.getText().toString();
                int n = Integer.parseInt(num);

                    n++;
                    textView.setText(String.valueOf(n));

            }
        });



        return view;
    }
}
