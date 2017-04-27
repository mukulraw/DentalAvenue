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



public class productadaper extends RecyclerView.Adapter<productadaper.myviewholder> {


    Context context;


    public productadaper(Context context){
        this.context=context;

    }

    @Override
    public productadaper.myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.product_list_model, parent, false);

        return new myviewholder(itemView);


    }

    @Override
    public void onBindViewHolder(productadaper.myviewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class myviewholder extends RecyclerView.ViewHolder{

        public myviewholder(View itemView) {
            super(itemView);

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
