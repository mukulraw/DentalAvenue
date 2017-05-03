package com.dentalavenue.dentalavenue;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.dentalavenue.dentalavenue.productPOJO.ProductDetail;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class productadaper extends RecyclerView.Adapter<productadaper.myviewholder> {


    Context context;
    List<ProductDetail> list = new ArrayList<>();


    public productadaper(Context context , List<ProductDetail> list)
    {
        this.context=context;
        this.list = list;
    }

    @Override
    public productadaper.myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.product_list_model, parent, false);

        return new myviewholder(itemView);


    }

    @Override
    public void onBindViewHolder(productadaper.myviewholder holder, int position) {

        ProductDetail item = list.get(position);

        holder.name.setText(item.getProName());
        holder.pass.setText(item.getQty());
        holder.roll.setText(item.getPrice());

        ImageLoader loader = ImageLoader.getInstance();

        loader.displayImage(item.getProImage() , holder.image);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{

        TextView name,pass,roll;
        ImageView image;
        RatingBar rating;



        public myviewholder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.text1);
            pass= (TextView)itemView.findViewById(R.id.text2);
            roll = (TextView)itemView.findViewById(R.id.text3);
            image = (ImageView) itemView.findViewById(R.id.imageView);
            rating= (RatingBar) itemView.findViewById(R.id.ratingBar);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm = ((MainActivity)context).getSupportFragmentManager();

                    FragmentTransaction ft = fm.beginTransaction();

                    Singleproduct frag = new Singleproduct();

                    Bundle b = new Bundle();

                    frag.setArguments(b);

                    ft.replace(R.id.replace , frag);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                    ft.addToBackStack(null);
                    ft.commit();
                }
            });

        }
    }


}
