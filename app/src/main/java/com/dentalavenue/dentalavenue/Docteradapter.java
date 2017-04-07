package com.dentalavenue.dentalavenue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Docteradapter extends FragmentStatePagerAdapter {



    public Docteradapter(FragmentManager f){
        super(f);

    }
    @Override
    public Fragment getItem(int position) {

        if (position == 0)
        {
            return new Docter();
        }
        else if (position == 1)
        {
            return new Customer();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

