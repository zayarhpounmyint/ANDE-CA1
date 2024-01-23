package com.example.helloworld;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class AttractionActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AttractionAdapter attractionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attractions);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        attractionAdapter = new AttractionAdapter();
        recyclerView.setAdapter(attractionAdapter);

        // Load food category items automatically when the page loads
        List<Attraction> foodItems = getItemsForCategory(R.id.foodBtn);
        attractionAdapter.setItems(foodItems);
    }

    public void onCategoryBtnClick(View view) {
        List<Attraction> cardItemList = getItemsForCategory(view.getId());
        attractionAdapter.setItems(cardItemList);
    }

    private List<Attraction> getItemsForCategory(int categoryId) {
        List<Attraction> items = new ArrayList<>();

        switch (categoryId) {
            case R.id.foodBtn:
                items.add(new Attraction(R.drawable.paris, "Harajuku Gyoza Lou", "description", 4.9,1.2,"website"));
                items.add(new Attraction(R.drawable.paris, "Sushiro", "", 4.9,1.2,"website"));
                items.add(new Attraction(R.drawable.paris, "Nisshin Tasuke", "", 4.9,1.2,"website"));
                items.add(new Attraction(R.drawable.paris, "Oreryu Shio Ramen", "", 4.9,1.2,"website"));
                // Add more food items
                break;
            case R.id.entertainBtn:
                items.add(new Attraction(R.drawable.paris, "Exciting Show 1", "", 4.9,1.2,"website"));
                items.add(new Attraction(R.drawable.paris, "Fun Game 2", "", 4.9,1.2,"website"));
                // Add more entertainment items
                break;
            case R.id.natureBtn:
                items.add(new Attraction(R.drawable.paris, "Scenic View 1", "", 4.9,1.2,"website"));
                items.add(new Attraction(R.drawable.paris, "Beautiful Garden 2", "", 4.9,1.2,"website"));
                // Add more nature items
                break;
            case R.id.sportsBtn:
                items.add(new Attraction(R.drawable.paris, "Sports View 1", "", 4.9,1.2,"website"));
                items.add(new Attraction(R.drawable.paris, "Beautiful Garden 2", "", 4.9,1.2,"website"));
                // Add more nature items
                break;
            case R.id.hotelBtn:
                items.add(new Attraction(R.drawable.paris, "Hotel View 1", "", 4.9,1.2,"website"));
                items.add(new Attraction(R.drawable.paris, "Beautiful Garden 2", "", 4.9,1.2,"website"));
                // Add more nature items
                break;
            case R.id.cultureBtn:
                items.add(new Attraction(R.drawable.paris, "Culture View 1", "", 4.9,1.2,"website"));
                items.add(new Attraction(R.drawable.paris, "Beautiful Garden 2", "", 4.9,1.2,"website"));
                // Add more nature items
                break;
        }

        return items;
    }

}
