package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView horizontalRecyclerView;
    private RecyclerView verticalRecyclerView;
    private HorizontalCityAdapter horizontalAdapter;
    private VerticalCityAdapter verticalAdapter;
    private List<City> horizontalDataList;
    private List<City> verticalDataList;
    private DatabaseHandler db;
    private Button allBtn;
    private Button popularBtn;
    private Button nearbyBtn;
    private Button recommendBtn;
    private EditText searchInput;
    private ImageButton searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize data lists
        horizontalDataList = new ArrayList<>();
        verticalDataList = new ArrayList<>();

        // Initialize search and category buttons
        searchInput = findViewById(R.id.searchInput);
        searchButton = findViewById(R.id.imageButton);

        allBtn = findViewById(R.id.allBtn);
        popularBtn = findViewById(R.id.popularBtn);
        nearbyBtn = findViewById(R.id.nearbyBtn);
        recommendBtn = findViewById(R.id.recommendBtn);


        db = new DatabaseHandler(this);

        // Set up the horizontal RecyclerView
        horizontalRecyclerView = findViewById(R.id.horizontal_recycler_view);
        horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        horizontalAdapter = new HorizontalCityAdapter(getHorizontalCitiesData());
        horizontalRecyclerView.setAdapter(horizontalAdapter);

        // Set up the vertical RecyclerView
        verticalRecyclerView = findViewById(R.id.vertical_recycler_view);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        verticalAdapter = new VerticalCityAdapter(getVerticalCitiesData());
        verticalRecyclerView.setAdapter(verticalAdapter);


        if (db.getCityCount() == 0) {
            initializeCityData();
        }

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the search query from the EditText
                String input = searchInput.getText().toString();

                // Check if the query is not empty
                if (!input.isEmpty()) {
                    // Use the getCitiesByName method to perform the search
                    List<City> searchResults = db.searchCityName(input);

                    // Update the adapter's data
                    horizontalAdapter.setNewItems(searchResults);
                    horizontalAdapter.notifyDataSetChanged();
                }
            }
        });

        allBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horizontalAdapter.setNewItems(db.getAllCities());
            }
        });

        popularBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horizontalAdapter.setNewItems(db.getCitiesByCategory("Popular"));
            }
        });

        nearbyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horizontalAdapter.setNewItems(db.getCitiesByCategory("Nearby"));
            }
        });

        recommendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horizontalAdapter.setNewItems(db.getCitiesByCategory("Recommended"));
            }
        });
    }

    public void initializeCityData() {
        db.addCity(new City("Tokyo", R.drawable.tokyo, "Beautiful and culturally rich metropolis, where ancient traditions seamlessly coexist with the bustle of modern urban life.", AttractionActivity.class, "Popular"));
        db.addCity(new City("Kyoto", R.drawable.kyoto, "Beautiful city with historical sites.", AttractionActivity.class, "Recommended"));
        db.addCity(new City("Bali", R.drawable.bali, "A paradise, celebrated for its lush landscapes, rich cultural heritage, and tranquil, spiritual atmosphere.", AttractionActivity.class, "Nearby"));
        db.addCity(new City("New York", R.drawable.newyork, "The city that never sleeps.", AttractionActivity.class, "Recommended"));
        db.addCity(new City("Paris", R.drawable.paris, "Renowned for its romantic ambiance, classic art, and world-class landmarks like the Eiffel Tower.", AttractionActivity.class, "Top"));
        db.addCity(new City("Rome", R.drawable.rome, "Widely known for their rich history, landmarks and culture.", AttractionActivity.class, "Top"));
    }

    private List<City> getHorizontalCitiesData() {
        return db.getAllCities();
    }

    // This method will fetch vertical cities data from the database
    private List<City> getVerticalCitiesData() {
        return db.getCitiesByCategory("Top");
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

    public void redirectToAttraction(View view) {
        Intent intent = new Intent(this, AttractionActivity.class);
        startActivity(intent);
    }
}