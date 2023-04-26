package com.acme.propdub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.widget.SearchView;

public class PropertySale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_sale);

        //blurring background image
        ImageView imageView = findViewById(R.id.background_image4);
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_about_us);
        Bitmap blurredBitmap = BlurBuilder.blur(this, originalBitmap);
        imageView.setImageBitmap(blurredBitmap);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle search query submission for properties for sale
                Intent intent = new Intent(PropertySale.this, SearchResults.class);
                intent.putExtra("search_query", query);
                intent.putExtra("search_type", "sale"); // Add search type (sale) to the intent
                startActivity(intent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle search query text changes, e.g., show/hide suggestions or filter results
                // You can implement this part depending on your specific requirements
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
