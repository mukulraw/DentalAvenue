package com.dentalavenue.dentalavenue;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.dentalavenue.dentalavenue.categoryPOJO.categoryBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class Category extends Fragment{
    RecyclerView grid;
    GridLayoutManager manager;
    Dataadapter dataadapter;
    ViewPager pager;
    List<com.dentalavenue.dentalavenue.categoryPOJO.Category> list;

CircleIndicator indicator;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.category_layout , container , false);


        indicator = (CircleIndicator) view.findViewById(R.id.circle);


        grid = (RecyclerView)view.findViewById(R.id.grid);
        manager = new GridLayoutManager(getContext() , 2);

        list = new ArrayList<>();

        dataadapter = new Dataadapter(getContext() , list);

        grid.setLayoutManager(manager);
        grid.setAdapter(dataadapter);

        pager = (ViewPager)view.findViewById(R.id.pager);

        final MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());

        pager.setAdapter(adapter);

        indicator.setViewPager(pager);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nationproducts.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AllAPIs cr = retrofit.create(AllAPIs.class);

        Call<categoryBean> call = cr.category("0");

        call.enqueue(new Callback<categoryBean>() {
            @Override
            public void onResponse(Call<categoryBean> call, Response<categoryBean> response) {

                list = response.body().getCategory();
                dataadapter.setGridData(list);

            }

            @Override
            public void onFailure(Call<categoryBean> call, Throwable throwable) {

            }
        });

        return view;

    }





    public class MyPagerAdapter extends FragmentStatePagerAdapter
    {


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new MyFrag();
        }

        @Override
        public int getCount() {
            return 4;
        }
    }


    public static class MyFrag extends Fragment
    {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.image, container, false);
            return view;
        }
    }



    public class Dataadapter extends RecyclerView.Adapter<Dataadapter.myviewholder>
    {

        List<com.dentalavenue.dentalavenue.categoryPOJO.Category> list = new ArrayList<>();
        Context context;

        public Dataadapter (Context context , List<com.dentalavenue.dentalavenue.categoryPOJO.Category> list)
        {
            this.context=context;
            this.list = list;
        }


        @Override
        public myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(context)
                    .inflate(R.layout.cart_model, parent, false);

            return new myviewholder(itemView);
        }


        public void setGridData(List<com.dentalavenue.dentalavenue.categoryPOJO.Category> list)
        {
            this.list = list;
            notifyDataSetChanged();
        }


        @Override
        public void onBindViewHolder(myviewholder holder, int position) {

            com.dentalavenue.dentalavenue.categoryPOJO.Category item = list.get(position);

            holder.text.setText(item.getCatName());

            ImageLoader loader = ImageLoader.getInstance();

            loader.displayImage(item.getCatImage() , holder.image);


        }

        @Override
        public int getItemCount()
        {
            return list.size();
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





}
