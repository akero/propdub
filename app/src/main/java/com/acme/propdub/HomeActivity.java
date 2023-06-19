package com.acme.propdub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private NavigationView navigationView;
    DrawerLayout drawerLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
try{
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menubutton);
            actionBar.setTitle("Noida, India");}

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    View lineView = findViewById(R.id.line);
    View lineView1 = findViewById(R.id.line1);
    View lineView2 = findViewById(R.id.line2);
    int alphaValue = (int) (0.2 * 255); // replace 0.2 with the actual alpha value
    int color = Color.argb(alphaValue, 0, 66, 116);
    lineView.setBackgroundColor(color);
    lineView1.setBackgroundColor(color);
    lineView2.setBackgroundColor(color);


    viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ImageAdapter());
        viewPager.setPageTransformer(new DepthPageTransformer());

        // This makes lower pages of the ViewPager show
        viewPager.setOffscreenPageLimit(3);
    // Positive margin to make adjacent pages visible
    viewPager.setPageTransformer(new MarginPageTransformer((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics())));

    navigationView = findViewById(R.id.id_view);
        navigationView.setNavigationItemSelectedListener(this);

    CoordinatorLayout coordinatorLayout = findViewById(R.id.featured1);
        coordinatorLayout.setOnClickListener(new CoordinatorLayout.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(HomeActivity.this, PropertyDetails.class));
        }
    });

        CoordinatorLayout coordinatorLayout1 = findViewById(R.id.featured2);

        coordinatorLayout1.setOnClickListener(new CoordinatorLayout.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, PropertyDetails.class));
            }
        });

        CoordinatorLayout coordinatorLayout2 = findViewById(R.id.featured3);
        coordinatorLayout2.setOnClickListener(new CoordinatorLayout.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, PropertyDetails.class));
            }
        });

}catch (Exception e){
    Log.d("tag15",e.toString());}
    }

    //menu code
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ID1:
                startActivity(new Intent(this, Favorites.class));
                break;
            case R.id.ID2:
                startActivity(new Intent(this, SavedSearches.class));
                break;
            case R.id.ID3:
                startActivity(new Intent(this, MortgageCalculator.class));
                break;
            case R.id.ID4:
                startActivity(new Intent(this, Settings1.class));
                break;
            case R.id.ID5:
                startActivity(new Intent(this, Support.class));
                break;
            case R.id.ID6:
                startActivity(new Intent(this, AboutUs.class));
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()== android.R.id.home){
            DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
        }
    }