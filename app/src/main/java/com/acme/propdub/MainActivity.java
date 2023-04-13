package com.acme.propdub;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.acme.propdub.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        drawer =findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.id_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, binding.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//TODO:
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // property sale button code
        View propertySaleButton = findViewById(R.id.property_sale_button);
        propertySaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPropertySaleActivity();
            }
        });

        // property rent button code
        View propertyRentButton = findViewById(R.id.property_rent_button);
        propertyRentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPropertyRentActivity();
            }
        });
    }

    // Method to navigate to PropertySale
    private void openPropertySaleActivity() {
        Intent intent = new Intent(MainActivity.this, PropertySale.class);
        startActivity(intent);
    }

    // Method to navigate to PropertyRent
    private void openPropertyRentActivity() {
        Intent intent = new Intent(MainActivity.this, PropertyRent.class);
        startActivity(intent);
    }

    // Adding the search bar and code to handle searches
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle search query submission
                Intent intent = new Intent(MainActivity.this, SearchResults.class);
                intent.putExtra("search_query", query);
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle search query text changes
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
//menu code
    //TODO: idk fix this shit
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
                startActivity(new Intent(this, Settings.class));
                break;
            case R.id.ID5:
                startActivity(new Intent(this, Support.class));
                break;
            case R.id.ID6:
                startActivity(new Intent(this, AboutUs.class));
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}