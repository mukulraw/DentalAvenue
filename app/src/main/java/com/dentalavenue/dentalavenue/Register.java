package com.dentalavenue.dentalavenue;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toolbar;

public class Register extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabs;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabs = (TabLayout) findViewById(R.id.layout);
        pager = (ViewPager) findViewById(R.id.pager);



        Docteradapter adapter = new Docteradapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        tabs.addTab(tabs.newTab().setText("DOCTOR"));
        tabs.addTab(tabs.newTab().setText("CUSTOMER"));

        tabs.setupWithViewPager(pager);

        tabs.getTabAt(0).setText("DOCTOR");
        tabs.getTabAt(1).setText("CUSTOMER");

    }
}
