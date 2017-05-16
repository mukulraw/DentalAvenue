package com.dentalavenue.dentalavenue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dentalavenue.dentalavenue.viewCartPOJO.CartDatum;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class Cartadapter extends RecyclerView.Adapter<Cartadapter.myviewholder> {

    Context context;
    List<CartDatum> list = new ArrayList<>();

    public Cartadapter(Context context , List<CartDatum> list)
    {
        this.context = context;
        this.list = list;
    }

    public void setGridData(List<CartDatum> list)
    {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public Cartadapter.myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.cart_list_model, parent, false);

        return new myviewholder(itemView);
    }


    @Override
    public void onBindViewHolder(Cartadapter.myviewholder holder, int position) {

        CartDatum item = list.get(position);

        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(false).build();

        ImageLoader loader = ImageLoader.getInstance();

        //loader.displayImage(item.get);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name , sku , price;


        public myviewholder(View itemView) {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.image);
            name = (TextView)itemView.findViewById(R.id.name);
            sku = (TextView)itemView.findViewById(R.id.sku);
            price = (TextView)itemView.findViewById(R.id.price);

        }


    }
}
