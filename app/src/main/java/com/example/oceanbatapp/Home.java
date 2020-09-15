package com.example.oceanbatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        Menu menu = navigationView.getMenu();
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);


        final Button carDetail = findViewById(R.id.button_detail_car);
        final Button carBook = findViewById(R.id.button_book_car);
        carDetail.setOnClickListener(this);
        carBook.setOnClickListener(this);

        final Button motorDetail = findViewById(R.id.button_detail_motor);
        final Button motorBook = findViewById(R.id.button_book_motor);
        motorDetail.setOnClickListener(this);
        motorBook.setOnClickListener(this);

        final Button houseDetail = findViewById(R.id.button_detail_house);
        final Button houseBook = findViewById(R.id.button_book_house);
        houseDetail.setOnClickListener(this);
        houseBook.setOnClickListener(this);

        final Button gardenDetail= findViewById(R.id.button_detail_garden);
        final Button gardenBook = findViewById(R.id.button_book_garden);
        gardenDetail.setOnClickListener(this);
        gardenBook.setOnClickListener(this);

    }

    /*public void logout(View view){
        FirebaseAuth.getInstance().signOut(); //logout
        startActivity(new Intent(getApplicationContext(), FirstPage.class));
        finish();
    }*/

    @Override
    public void onClick(View view) {
        //String servicesName = "";
        //String servicesType = "";

        switch (view.getId()){
            case R.id.button_detail_car: {
                Intent intent = new Intent(Home.this,DetailService.class).putExtra("pass","car");
                startActivity(intent);
                break;
            }
            case R.id.button_detail_motor: {
                Intent intent = new Intent(Home.this,DetailService.class).putExtra("pass","motor");
                startActivity(intent);
                break;
            }
            case R.id.button_detail_house: {
                Intent intent = new Intent(Home.this,DetailService.class).putExtra("pass","house");
                startActivity(intent);
                break;
            }
            case R.id.button_detail_garden: {
                Intent intent = new Intent(Home.this,DetailService.class).putExtra("pass","garden");
                startActivity(intent);
                break;
            }
            case R.id.button_book_car:{
                Intent intent = new Intent(Home.this, BookingPage.class).putExtra("pass","car");
                startActivity(intent);
                break;
            }
            case R.id.button_book_motor:{
                Intent intent = new Intent(Home.this, BookingPage.class).putExtra("pass","motor");
                startActivity(intent);
                break;
            }
            case R.id.button_book_house:{
                Intent intent = new Intent(Home.this, BookingPage.class).putExtra("pass","house");
                startActivity(intent);
                break;
            }
            case R.id.button_book_garden:{
                Intent intent = new Intent(Home.this, BookingPage.class).putExtra("pass","garden");
                startActivity(intent);
                break;
            }
        }
    }
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home: {
                Intent intent = new Intent(Home.this,Home.class);
                startActivity(intent);
                break;
            }
            case R.id.nav_profile: {
                Intent intent = new Intent(Home.this,ShowProfile.class);
                startActivity(intent);
                break;
            }
            case R.id.nav_logout: {
                FirebaseAuth.getInstance().signOut(); //logout
                startActivity(new Intent(getApplicationContext(), FirstPage.class));
                break;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
