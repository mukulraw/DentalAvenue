package com.dentalavenue.dentalavenue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;
    DrawerLayout drawer;

    TextView wish , logout , off;
    TextView myprofile;
    TextView cart;

    SharedPreferences pref;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("mypref" , MODE_PRIVATE);
        edit = pref.edit();

        toolbar= (Toolbar) findViewById(R.id.toolbar);


        wish = (TextView)findViewById(R.id.wish);
        myprofile = (TextView) findViewById(R.id.change);
        cart = (TextView) findViewById(R.id.cart);
        logout = (TextView)findViewById(R.id.logout);
        off = (TextView)findViewById(R.id.offer);


        toolbar.setTitle("Dental Avenue");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawer = (DrawerLayout) findViewById(R.id.activity_main);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open , R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this , Wishlist.class);
                drawer.closeDrawer(GravityCompat.START);
                startActivity(intent);

            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this , cart.class);
                drawer.closeDrawer(GravityCompat.START);
                startActivity(intent);

            }
        });


        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Offers.class);
                startActivity(i);
            }
        });


        myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Myprofile.class);
                drawer.closeDrawer(GravityCompat.START);
                startActivity(intent);
            }
        });



        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.dentalavenue.dentalavenue.cart.class);
                drawer.closeDrawer(GravityCompat.START);
                startActivity(intent);
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this , LoginType.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

                edit.remove("user");
                edit.remove("type");
                edit.remove("pass");
                edit.apply();


                bean b = (bean)getApplicationContext();

                b.name = "";
                b.userId = "";
                b.email = "";

                startActivity(i);
                finish();

            }
        });








        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Category frag1 = new Category();
        ft.replace(R.id.replace , frag1);
        //ft.addToBackStack(null);
        ft.commit();



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu , menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.search)
        {
            Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.cart)
        {
            Toast.makeText(MainActivity.this, "Cart", Toast.LENGTH_SHORT).show();
        }


        return true;

    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }
}
