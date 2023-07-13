package com.acme.propdub;

import android.content.Intent;

import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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

//TODO: populate search code, UI, sidebar code
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private AppBarConfiguration appBarConfiguration;
    //  private ActivityMainBinding binding;
    private DrawerLayout drawer;
    private ImageView menuIcon;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the drawer variable
        drawer = findViewById(R.id.drawer_layout);
        menuIcon = findViewById(R.id.my_icon);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        navigationView = findViewById(R.id.id_view);
        navigationView.setNavigationItemSelectedListener(this);

        // property details button code
        View propertyDetailsButton = findViewById(R.id.property_details_button);
        propertyDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openPropertyDetailsActivity();
            }
        });
        
        // agent profile button code
        View agentButton = findViewById(R.id.agent_button);
        agentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openAgentActivity();
            }
        });

        // home button code
        View homeButton = findViewById(R.id.home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHomeActivity();
            }
        });

        // review popup button code
        View reviewButton = findViewById(R.id.review_popup_button);
        reviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openReviewPopupActivity();
            }
        });

        // Sign up button code
        View signupButton = findViewById(R.id.signup_button);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSignUpActivity();
            }
        });

        // Sign in button code
        View signinButton = findViewById(R.id.signin_button);
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSignInActivity();
            }
        });

        // search button code
        View searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSearchActivity();
            }
        });

        // searchmap button code
        View searchMapButton = findViewById(R.id.search_map_button);
        searchMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSearchMapActivity();
            }
        });

        // agent listings button code
        View agentsearchMapButton = findViewById(R.id.agent_listings);
        agentsearchMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AgentListings.class);
                startActivity(intent);
            }
        });

        // property sale button code
        View propertySaleButton = findViewById(R.id.property_sale_button);
        propertySaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("tag1", "In sale click");
                openPropertySaleActivity();
            }
        });

        // schedule visit button code
        View propertyVisitButton = findViewById(R.id.schedule_visit_button);
        propertyVisitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("tag1", "In sale click");
                openScheduleActivity();
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

        Button reviews= findViewById(R.id.review_button);
        reviews.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent= new Intent(MainActivity.this, Ratings.class);
                startActivity(intent);
;            }
        });
    }

    // Method to navigate to PropertySale
    public void onMenuButtonClick(View view) {
        if (drawer != null) {
            drawer.openDrawer(GravityCompat.START);
        }
    }

    private void openPropertySaleActivity() {

        Log.d("tag1", "In sale intent");
        Intent intent = new Intent(MainActivity.this, PropertySale.class);
        Log.d("tag1", "In sale intent 2");
        startActivity(intent);
    }

    private void openPropertyDetailsActivity() {

        Log.d("tag1", "In sale intent");
        Intent intent = new Intent(MainActivity.this, PropertyDetails.class);
        Log.d("tag1", "In sale intent 2");
        startActivity(intent);
    }

    private void openSignInActivity() {

        Log.d("tag1", "In sale intent");
        Intent intent = new Intent(MainActivity.this, login.class);
        Log.d("tag1", "In sale intent 2");
        startActivity(intent);
    }

    private void openSignUpActivity() {

        Log.d("tag1", "In sale intent");
        Intent intent = new Intent(MainActivity.this, SignUp.class);
        Log.d("tag1", "In sale intent 2");
        startActivity(intent);
    }

    // Method to navigate to PropertyRent
    private void openPropertyRentActivity() {
        Intent intent = new Intent(MainActivity.this, PropertyRent.class);
        startActivity(intent);
    }

    // Method to navigate to Home activity
    private void openHomeActivity() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    private void openSearchActivity(){
        Intent intent= new Intent(MainActivity.this, Search.class);
        startActivity(intent);
    }

    private void openSearchMapActivity(){
        Intent intent= new Intent(MainActivity.this, SearchByMap.class);
        startActivity(intent);
    }

    // Method to navigate to schedule visit
    private void openScheduleActivity() {
        Intent intent = new Intent(MainActivity.this, ScheduleVisit.class);
        startActivity(intent);
    }

    // Method to navigate to agent details
    private void openAgentActivity() {
        Intent intent = new Intent(MainActivity.this, AgentProfile.class);
        startActivity(intent);
    }

    // Method to navigate to agent details
    private void openReviewPopupActivity() {
        Intent intent = new Intent(MainActivity.this, ReviewPopup.class);
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
}