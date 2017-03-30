package com.dentalavenue.dentalavenue;

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

import me.relex.circleindicator.CircleIndicator;


public class Category extends Fragment{
    RecyclerView grid;
    GridLayoutManager manager;

    ViewPager pager;

CircleIndicator indicator;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.category_layout , container , false);


        indicator = (CircleIndicator) view.findViewById(R.id.circle);


        grid = (RecyclerView)view.findViewById(R.id.grid);
        manager = new GridLayoutManager(getContext() , 2);


        Dataadapter dataadapter = new Dataadapter(getContext());

        grid.setLayoutManager(manager);
        grid.setAdapter(dataadapter);

        pager = (ViewPager)view.findViewById(R.id.pager);

        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());

        pager.setAdapter(adapter);

        indicator.setViewPager(pager);

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









}
