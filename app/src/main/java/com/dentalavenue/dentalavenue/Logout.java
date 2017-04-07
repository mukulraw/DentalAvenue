package com.dentalavenue.dentalavenue;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class Logout extends AppCompatActivity {
    TabLayout tabs;
    ViewPager pager;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        tabs = (TabLayout) findViewById(R.id.layout);
        pager = (ViewPager) findViewById(R.id.pager);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setTitle("Login");
        toolbar.setTitleTextColor(Color.WHITE);

        loginadapter adapter = new loginadapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        tabs.addTab(tabs.newTab().setText("DOCTOR LOGIN"));
        tabs.addTab(tabs.newTab().setText("CUSTOMER LOGIN"));

        tabs.setupWithViewPager(pager);

        tabs.getTabAt(0).setText("DOCTOR LOGIN");
        tabs.getTabAt(1).setText("CUSTOMER LOGIN");




    }

    public class loginadapter extends FragmentStatePagerAdapter {



        public loginadapter (FragmentManager f){
            super(f);

        }
        @Override
        public Fragment getItem(int position) {

            if (position == 0)
            {
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                return new Doctorlogin();
            }
            else if (position == 1)
            {
                toolbar.setBackgroundColor(getResources().getColor(R.color.red));
                tabs.setBackgroundColor(getResources().getColor(R.color.red));

                return new Customerlogin();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}

