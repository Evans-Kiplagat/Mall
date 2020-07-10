package com.example.mall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private FrameLayout frame;
    private NavigationView navigationView;
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        utils.initSharedPreference(this);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,drawer,toolbar,R.string.open_navigation_drawer,R.string.close_navigation_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,new fragment_main());
        transaction.commit();
    }

    private void initViews() {
        drawer =findViewById(R.id.drawer);
        navigationView =findViewById(R.id.nav_view);
        toolbar= findViewById(R.id.toolbar);
        frame= findViewById(R.id.fragment_container);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cart:
                //todo navigate the user to the cart activity
                break;
            case R.id.category:
            //todo
                break;
            case R.id.terms:
                //todo navigate the user to the cart activity
                break;
            case R.id.info:
                //todo navigate the user to the cart activity
                break;
            case R.id.licience:
                //todo navigate the user to the cart activity
                Toast.makeText(this, "saving... up", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imagepic:
                //todo save image
                Toast.makeText(this, "saving... image", Toast.LENGTH_SHORT).show();

                uploader();
                break;

        }
        return true;
    }

    private void uploader() {
        //todo use firebase to upload a pic there :


    }
}
