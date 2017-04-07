package com.dentalavenue.dentalavenue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tvs on yr/31/2017.
 */

public class Cartadapter extends RecyclerView.Adapter<Cartadapter.myviewholder> {

    Context context;

    public Cartadapter(Context context){
        this.context = context;
    }

    @Override
    public Cartadapter.myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.cart_list_model, parent, false);

        return new myviewholder(itemView);
    }


    @Override
    public void onBindViewHolder(Cartadapter.myviewholder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class myviewholder extends RecyclerView.ViewHolder{

        public myviewholder(View itemView) {
            super(itemView);
        }


    }
}
