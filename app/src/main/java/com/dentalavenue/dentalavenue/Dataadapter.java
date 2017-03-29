package com.dentalavenue.dentalavenue;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.id.list;
import static com.dentalavenue.dentalavenue.R.id.text;

public class Dataadapter extends RecyclerView.Adapter<Dataadapter.myviewholder> {

    Context context;

    public Dataadapter (Context context){

        this.context=context;


    }


    @Override
    public myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.cart_model, parent, false);

        return new myviewholder (itemView);




    }

    @Override
    public void onBindViewHolder(Dataadapter.myviewholder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return 10;
    }



    class myviewholder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text;


        public myviewholder(View itemView) {
            super(itemView);


            image = (ImageView)itemView.findViewById(R.id.image);
            text =(TextView)itemView.findViewById(R.id.text);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    FragmentManager fm = ((MainActivity)context).getSupportFragmentManager();

                    FragmentTransaction ft = fm.beginTransaction();

                    SubCategory frag = new SubCategory();

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
