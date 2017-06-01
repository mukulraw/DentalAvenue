package com.dentalavenue.dentalavenue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dentalavenue.dentalavenue.viewCartPOJO.CartDatum;
import com.dentalavenue.dentalavenue.viewWishlistPOJO.WishlistDetail;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.*;



public class Wishadapter extends RecyclerView.Adapter<Wishadapter.myviewholder> {

    Context context;
    List<WishlistDetail> list=new ArrayList<>();


    public Wishadapter (Context context, List<WishlistDetail> list){

        this.context = context;
        this.list=list;
    }


    public void setGridData(List<WishlistDetail> list)
    {
        this.list=list;
        notifyDataSetChanged();
    }

    @Override
    public Wishadapter.myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.wish_list_model, parent, false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(Wishadapter.myviewholder holder, int position) {
        WishlistDetail item = list.get(position);


        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(false).build();

        ImageLoader loader = ImageLoader.getInstance();

        loader.displayImage(item.getProImage(),holder.image);

        holder.pname.setText(item.getProSku());
        holder.sku.setText(item.getProSku());
        holder.price.setText(item.getSalePriceToDoctor());
        Toast.makeText(context,item.getProSku(),Toast.LENGTH_LONG).show();



    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class myviewholder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView pname,sku,price;



        public myviewholder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            pname=(TextView)itemView.findViewById(R.id.pname);
            sku=(TextView)itemView.findViewById(R.id.sku);
            price=(TextView)itemView.findViewById(R.id.price);
        }
    }
}


