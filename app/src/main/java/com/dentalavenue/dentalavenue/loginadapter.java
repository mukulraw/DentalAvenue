package com.dentalavenue.dentalavenue;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class loginadapter extends FragmentStatePagerAdapter {



    public loginadapter (FragmentManager f){
        super(f);

    }
    @Override
    public Fragment getItem(int position) {

        if (position == 0)
        {
            return new Doctorlogin();
        }
        else if (position == 1)
        {
            return new Customerlogin();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}



