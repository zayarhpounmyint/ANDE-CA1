package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
public class AttractionActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AttractionAdapter attractionAdapter;
    private DatabaseHandler db;
    private EditText searchEditText;
    private ImageButton searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attractions);

        Button backButton = findViewById(R.id.backBtn);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the activity you want to go back to
                Intent intent = new Intent(AttractionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        db = new DatabaseHandler(this);
        initializeDatabaseWithAttractions();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        attractionAdapter = new AttractionAdapter();
        recyclerView.setAdapter(attractionAdapter);

        // Load food category items automatically when the page loads
        List<Attraction> foodItems = getItemsForCategory(R.id.foodBtn);
        attractionAdapter.setItems(foodItems);

        searchEditText = findViewById(R.id.searchAttractionsText);
        searchButton = findViewById(R.id.searchAttractionsBtn);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = searchEditText.getText().toString();
                performSearch(query);
            }
        });
    }

    private void performSearch(String query) {
        // Perform search in the database and get results
        List<Attraction> searchResults = db.searchAttractionsByTitle(query);

        // Update the RecyclerView with the search results
        attractionAdapter.setItems(searchResults);
    }

    public void onCategoryBtnClick(View view) {
        List<Attraction> cardItemList = getItemsForCategory(view.getId());
        attractionAdapter.setItems(cardItemList);
    }

    private void initializeDatabaseWithAttractions() {
        //db.clearAllData();
        if (db.getAttractionsCount() == 0) {
            // Add initial attractions
            db.addAttraction(new Attraction("Food", R.drawable.harajuku_gyoza, "Harajuku Gyoza Lou", "description", 4.9, 1.2, "website"));
            db.addAttraction(new Attraction("Food", R.drawable.sushiro, "Sushiro", "description", 4.9, 1.2, "website"));
            db.addAttraction(new Attraction("Food", R.drawable.nisshin, "Nisshin Tasuke", "description", 4.9, 1.2, "website"));
            db.addAttraction(new Attraction("Food", R.drawable.ramen, "Oreryu Shio Ramen", "description", 4.9, 1.2, "website"));
            db.addAttraction(new Attraction("Entertainment", R.drawable.disneyland, "DisneyLand", "description", 4.9, 1.2, "website"));
            db.addAttraction(new Attraction("Entertainment", R.drawable.disneysea, "DisneySea", "description", 4.9, 1.2, "website"));
            db.addAttraction(new Attraction("Nature", R.drawable.euno_park, "Ueno Park", "A large public park known for its museums, zoo, and during the spring, its beautiful cherry blossoms. It's a great place for a leisurely walk or a picnic.", 4.9, 1.2, "website"));
            db.addAttraction(new Attraction("Nature", R.drawable.shinjuku_gyoen, "Shinjuku Gyoen National Garden", "This spacious park blends three distinct styles: traditional Japanese, English Landscape, and French Formal. It's particularly stunning during cherry blossom and autumn leaf seasons.", 4.9, 1.2, "website"));
            db.addAttraction(new Attraction("Nature", R.drawable.yoyogi, "Yoyogi Park", "Known for its wide-open spaces, this park is a popular spot for jogging, picnicking, and leisurely strolls. It's also close to the Meiji Shrine, another green and peaceful area.", 4.9, 1.2, "website"));
            db.addAttraction(new Attraction("Sports", R.drawable.volleyball, "Beach Volleyball at Odaiba Beach", "description", 4.9, 1.2, "website"));
            db.addAttraction(new Attraction("Hotel", R.drawable.hotel, "Park Hyatt Tokyo", "Famous from the movie \"Lost in Translation,\" this hotel offers luxurious rooms with stunning city views, located in Shinjuku.", 4.9, 1.2, "website"));
            db.addAttraction(new Attraction("Culture", R.drawable.imperial, "The Imperial Palace", "Located in the heart of Tokyo, the Imperial Palace is the primary residence of the Emperor of Japan. While the palace itself is generally not open to the public, the East Gardens offer a beautiful walk and a glimpse into Japanese history.", 4.9, 1.2, "website"));
            db.addAttraction(new Attraction("Culture", R.drawable.museum, "Tokyo National Museum", "Located in Ueno Park, this museum houses the largest collection of Japanese art in the world, including samurai armor, ancient pottery, and ukiyo-e prints.", 4.9, 1.2, "website"));
        }
    }


    private List<Attraction> getItemsForCategory(int categoryId) {
        List<Attraction> items = new ArrayList<>();

        String category = getCategoryForId(categoryId);
        items = db.getAttractionsByCategory(category);

        return items;
    }

    private String getCategoryForId(int categoryId) {
        switch (categoryId) {
            case R.id.foodBtn:
                return "Food";
            case R.id.entertainBtn:
                return "Entertainment";
            case R.id.natureBtn:
                return "Nature";
            case R.id.sportsBtn:
                return "Sports";
            case R.id.hotelBtn:
                return "Hotel";
            case R.id.cultureBtn:
                return "Culture";
            default:
                return "All";
        }
    }


}
