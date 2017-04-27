package com.dentalavenue.dentalavenue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dentalavenue.dentalavenue.categoryPOJO.*;
import com.dentalavenue.dentalavenue.categoryPOJO.Category;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class SubCategory extends Fragment
{
    TabLayout tabs;
    ViewPager pager;
    TextView label;
    ImageView image;
    String catName , catImage , id;
    List<com.dentalavenue.dentalavenue.categoryPOJO.Category> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.subcategory , container , false);

        catName = getArguments().getString("name");
        catImage = getArguments().getString("image");
        id = getArguments().getString("id");

        tabs = (TabLayout) view.findViewById(R.id.tabs);
        pager = (ViewPager) view.findViewById(R.id.pager);
        image = (ImageView) view.findViewById(R.id.image);
        label = (TextView)view.findViewById(R.id.label);

        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(false).build();

        ImageLoader loader = ImageLoader.getInstance();

        loader.displayImage(catImage , image , options);

        label.setText(catName);

        list = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nationproducts.in/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AllAPIs cr = retrofit.create(AllAPIs.class);

        Call<categoryBean> call = cr.category(id);

        call.enqueue(new Callback<categoryBean>() {
            @Override
            public void onResponse(Call<categoryBean> call, Response<categoryBean> response) {

                list = response.body().getCategory();

                for (int i = 0 ; i < list.size() ; i++)
                {
                    tabs.addTab(tabs.newTab().setText(list.get(i).getCatName()));
                }

                MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager() , list);

                pager.setAdapter(adapter);

                tabs.setupWithViewPager(pager);


                for (int i = 0 ; i < tabs.getTabCount() ; i++)
                {
                    tabs.getTabAt(i).setText(list.get(i).getCatName());
                }


            }

            @Override
            public void onFailure(Call<categoryBean> call, Throwable throwable) {

            }
        });


        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;

    }


    public class MyPagerAdapter extends FragmentStatePagerAdapter{

        List<Category> count = new ArrayList<>();

        public MyPagerAdapter(FragmentManager fm , List<Category> count) {
            super(fm);
            this.count = count;
        }

        @Override
        public Fragment getItem(int position) {

            Pages frag = new Pages();
            Bundle b = new Bundle();
            b.putString("id" , count.get(position).getCatId());
            frag.setArguments(b);

            return frag;
        }

        @Override
        public int getCount() {
            return count.size();
        }
    }


    public static class Pages extends Fragment
    {
        RecyclerView recycler;
        GridLayoutManager manager;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.product_list , container , false);

            recycler = (RecyclerView) view.findViewById(R.id.recycer);
            manager = new GridLayoutManager(getContext(),1);
            productadaper productadaper =new productadaper(getContext());





            recycler.setLayoutManager(manager);
            recycler.setAdapter(productadaper);
            return view;


        }
    }

}
