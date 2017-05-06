package com.dentalavenue.dentalavenue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dentalavenue.dentalavenue.productPOJO.ProductDetail;

import java.util.ArrayList;
import java.util.List;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

    private Context context;
    private List<ProductDetail> list = new ArrayList<>();


    public SearchAdapter(Context context , List<ProductDetail> list)
    {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.search_list_model , null);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ProductDetail item = list.get(position);

        holder.imageView.setText(item.getProName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView imageView;



        public MyViewHolder(View itemView) {
            super(itemView);

        imageView = (TextView) itemView.findViewById(R.id.image);
        }
    }
}

