package com.dentalavenue.dentalavenue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.View.*;



public class Wishadapter extends RecyclerView.Adapter<Wishadapter.myviewholder> {

    Context context;


    public Wishadapter (Context context){
        this.context = context;
    }

    @Override
    public Wishadapter.myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.wish_list_model, parent, false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(Wishadapter.myviewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }



    class myviewholder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView text;



        public myviewholder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}


