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
import java.util.Arrays;
import java.util.List;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private NavigationView navigationView;
    DrawerLayout drawerLayout;
    private ViewPager2 viewPager;
    private DiscreteScrollView discreteScrollView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Initialize and setup your DiscreteScrollView
        discreteScrollView = findViewById(R.id.picker);

        List<Integer> images = Arrays.asList(
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5
        );

        List<String> titles = Arrays.asList(
                "Azizi Park Avenue",
                "Title 2",
                "Title 3",
                "Title 4",
                "Title 5"
        );

        List<String> subtitles = Arrays.asList(
                "Street 1 - Dubai - United Arab Emirates",
                "Subtitle 2",
                "Subtitle 3",
                "Subtitle 4",
                "Subtitle 5"
        );

        try {
            adapter = new MyAdapter(images, titles, subtitles);



            discreteScrollView.setAdapter(adapter);



            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeAsUpIndicator(R.drawable.menubutton);
                actionBar.setTitle("Noida, India");
            }

            drawerLayout = findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();

            //setting color of the demarcators in top bar
            View lineView = findViewById(R.id.line);
            View lineView1 = findViewById(R.id.line1);
            View lineView2 = findViewById(R.id.line2);
            int alphaValue = (int) (0.2 * 255); // replace 0.2 with the actual alpha value
            int color = Color.argb(alphaValue, 0, 66, 116);
            lineView.setBackgroundColor(color);
            lineView1.setBackgroundColor(color);
            lineView2.setBackgroundColor(color);

            TextView proptype = findViewById(R.id.ourrecommendations);
            int h = proptype.getMeasuredHeight();
            int w = proptype.getMeasuredWidth();
            Log.d("taga", String.valueOf(h) + " " + String.valueOf(w));

    /*        viewPager = findViewById(R.id.viewPager);
            viewPager.setAdapter(new ImageAdapter());
            viewPager.setPageTransformer(new DepthPageTransformer());

            // This makes lower pages of the ViewPager show
            viewPager.setOffscreenPageLimit(3);
            // Positive margin to make adjacent pages visible
            viewPager.setPageTransformer(new MarginPageTransformer((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics())));
*/
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

            final View view1 = findViewById(R.id.ourrecommendations);
            final View view2 = findViewById(R.id.topbuttons1);

            view1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    // Ensure we call this only once
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                        view1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        view1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }

                    int[] location1 = new int[2];
                    int[] location2 = new int[2];

                    view1.getLocationOnScreen(location1);
                    view2.getLocationOnScreen(location2);

                    int xDistance = Math.abs(location1[0] - location2[0]);
                    int yDistance = Math.abs(location1[1] - location2[1]);

                    Log.d("taga", "X Distance: " + xDistance + " pixels, Y Distance: " + yDistance + " pixels");
                }
            });
        } catch (Exception e) {
            Log.d("tag15", e.toString());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
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