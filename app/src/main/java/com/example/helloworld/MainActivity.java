package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView horizontalRecyclerView;
    private RecyclerView verticalRecyclerView;
    private HorizontalCityAdapter horizontalAdapter;
    private VerticalCityAdapter verticalAdapter;
    private List<City> horizontalDataList;
    private List<City> verticalDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize data lists
        horizontalDataList = new ArrayList<>();
        verticalDataList = new ArrayList<>();

        // Populate data lists with your items
        prepareData();

        // Set up the horizontal RecyclerView
        horizontalRecyclerView = findViewById(R.id.horizontal_recycler_view);
        horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        horizontalAdapter = new HorizontalCityAdapter(horizontalDataList);
        horizontalRecyclerView.setAdapter(horizontalAdapter);

        // Set up the vertical RecyclerView
        verticalRecyclerView = findViewById(R.id.vertical_recycler_view);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        verticalAdapter = new VerticalCityAdapter(verticalDataList);
        verticalRecyclerView.setAdapter(verticalAdapter);
    }

    private void prepareData() {
        // Populate the horizontal data list
        horizontalDataList.add(new City("Kyoto", R.drawable.kyoto, "Beautiful city with historical sites.", AttractionActivity.class));
        horizontalDataList.add(new City("New York", R.drawable.newyork, "The city that never sleeps.", AttractionActivity.class));
        // Add more items as needed...

        // Populate the vertical data list
        verticalDataList.add(new City("Paris", R.drawable.paris, "Renowned for its romantic ambiance, classic art, and world-class landmarks like the Eiffel Tower.", AttractionActivity.class));
        verticalDataList.add(new City("Rome", R.drawable.rome, "Widely known for their rich history, landmarks and culture.", AttractionActivity.class));
    }

    // Add the following code

    String msg = "Android : ";

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }
    // End of Adding the code

    public void redirectToParis(View view) {
        Intent intent = new Intent(this, AttractionActivity.class);
        startActivity(intent);
    }
}