package com.dentalavenue.dentalavenue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dentalavenue.dentalavenue.OfferPOJO.Offer;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.MyViewHolder> {

    Context context;
    List<Offer> list = new ArrayList<>();

    public OfferAdapter(Context context , List<Offer> list){

        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.offer_model , null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Offer item = list.get(position);

        ImageLoader loader = ImageLoader.getInstance();

        loader.displayImage(item.getImage() , holder.image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.image);

        }
    }
}
