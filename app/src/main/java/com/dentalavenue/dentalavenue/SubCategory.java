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


public class SubCategory extends Fragment
{
    TabLayout tabs;
    ViewPager pager;
    ImageView image;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.subcategory , container , false);
        tabs = (TabLayout) view.findViewById(R.id.tabs);
        pager = (ViewPager) view.findViewById(R.id.pager);
        image = (ImageView) view.findViewById(R.id.image);


        tabs.addTab(tabs.newTab().setText("SUB-CATEGORY"));
        tabs.addTab(tabs.newTab().setText("SUB-CATEGORY"));
        tabs.addTab(tabs.newTab().setText("SUB-CATEGORY"));
        tabs.addTab(tabs.newTab().setText("SUB-CATEGORY"));
        tabs.addTab(tabs.newTab().setText("SUB-CATEGORY"));


        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());

        pager.setAdapter(adapter);

        tabs.setupWithViewPager(pager);


        for (int i = 0 ; i < tabs.getTabCount() ; i++)
        {
            tabs.getTabAt(i).setText("SUB-CATEGORY");
        }


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


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new Pages();
        }

        @Override
        public int getCount() {
            return 5;
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
