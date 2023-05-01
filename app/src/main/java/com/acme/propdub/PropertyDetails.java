package com.acme.propdub;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class PropertyDetails extends AppCompatActivity {

    private GestureDetector gestureDetector;
    private int[] imageIds;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_property_details);

            ImageView imageView = findViewById(R.id.background_image3);
            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_about_us);
            Bitmap blurredBitmap = BlurBuilder.blur(this, originalBitmap);
            imageView.setImageBitmap(blurredBitmap);

            // Code for scrolling images
            ViewSwitcher imageSwitcher = findViewById(R.id.image_switcher);
            imageIds = new int[]{R.drawable.propertyimage1, R.drawable.propertyimage2, R.drawable.propertyimage3};
            currentIndex = 0;
            ImageView imageView1 = (ImageView) imageSwitcher.getChildAt(0);
            imageView1.setImageResource(imageIds[currentIndex]);
            ImageView imageView2 = (ImageView) imageSwitcher.getChildAt(1);
            imageView2.setImageResource(imageIds[currentIndex + 1]);
            gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
                private static final int SWIPE_THRESHOLD = 100;
                private static final int SWIPE_VELOCITY_THRESHOLD = 100;

                @Override
                public boolean onDown(MotionEvent e) {
                    return true;
                }

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    boolean result = false;
                    try {
                        float diffX = e2.getX() - e1.getX();
                        float diffY = e2.getY() - e1.getY();
                        if (Math.abs(diffX) > Math.abs(diffY)) {
                            if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                                if (diffX > 0) {
                                    // Swipe right
                                    if (currentIndex > 0) {
                                        currentIndex--;
                                        imageView1.setImageResource(imageIds[currentIndex]);
                                        imageView2.setImageResource(imageIds[currentIndex + 1]);
                                        imageSwitcher.showPrevious();
                                    }
                                } else {
                                    // Swipe left
                                    if (currentIndex < imageIds.length - 2) {
                                        currentIndex++;
                                        imageView1.setImageResource(imageIds[currentIndex]);
                                        imageView2.setImageResource(imageIds[currentIndex + 1]);
                                        imageSwitcher.showNext();
                                    }
                                }
                                result = true;
                            }
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    return result;
                }
            });
            imageSwitcher.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
            });

            // contact button code
            View contactButton = findViewById(R.id.contact);
            contactButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openContactActivity();
                }
            });

            // mortgage calculator button code
            View mortgage_calculatorButton = findViewById(R.id.mortgage_calculator);
            mortgage_calculatorButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openMortgageActivity();
                }
            });

            // Location on map button code
            View locationOnMapButton = findViewById(R.id.location_on_map);
            locationOnMapButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //openPropertySaleActivity();
                }
            });

            // schedule button code
            View scheduleButton = findViewById(R.id.schedule_viewing);
            scheduleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openScheduleButtonActivity();
                }
            });

            // video button code
            View videoButton = findViewById(R.id.video);
            videoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //openPropertySaleActivity();
                }
            });

            // documents viewer button code
            View documentsViewerButton = findViewById(R.id.documents_viewer);
            documentsViewerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDocViewerActivity();
                }
            });
        } catch (Exception e) {
            Log.d("tag4", e.toString());
        }
    }

    // Method to navigate to DocViewer
    private void openDocViewerActivity() {
        Intent intent = new Intent(PropertyDetails.this, DocViewer.class);
        startActivity(intent);
    }

    private void openScheduleButtonActivity() {
        Intent intent = new Intent(PropertyDetails.this, ScheduleVisit.class);
        startActivity(intent);
    }

    private void openMortgageActivity() {
        Intent intent = new Intent(PropertyDetails.this, MortgageCalculator.class);
        startActivity(intent);
    }

    // Method to navigate to Contact
    private void openContactActivity() {
        Intent intent = new Intent(PropertyDetails.this, Contact.class);
        startActivity(intent);
    }
}
