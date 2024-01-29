package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
=======
import android.widget.ImageView;
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;


public class AttractionDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_details);

        Button backButton = findViewById(R.id.backBtn);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the activity you want to go back to
                Intent intent = new Intent(AttractionDetailsActivity.this, AttractionActivity.class);
                startActivity(intent);
            }
        });


<<<<<<< HEAD
        // Get data from the intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        String desc = intent.getStringExtra("Description");
        String rating = intent.getStringExtra("Rating");
        String distance = intent.getStringExtra("Distance");
        String website = intent.getStringExtra("Website");

        // Set data to views on the details page
=======

        // Get data from the intent
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
//        int image = intent.getIntExtra("Image",0);
//        String title = intent.getStringExtra("Title");
//        String desc = intent.getStringExtra("Description");
//        Double rating = intent.getDoubleExtra("Rating",0);
//        String location = intent.getStringExtra("Location");
//        String distance = intent.getStringExtra("Distance");
//        String website = intent.getStringExtra("Website");

        DatabaseHandler db = new DatabaseHandler(this);
        Attraction attractionDetails = db.getAttraction(id);
        int image = attractionDetails.getImage();
        String title = attractionDetails.getTitle();
        String desc = attractionDetails.getDescription();
        Double rating = attractionDetails.getRating();
        String location = attractionDetails.getLocation();
        String website = attractionDetails.getWebsite();



        // Set data to views on the details page
        ImageView attractionImg = findViewById(R.id.attractionImg);
        attractionImg.setImageResource(image);

>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
        TextView textDetailsTitle = findViewById(R.id.textDetailsTitle);
        textDetailsTitle.setText(title);

        TextView textDetailsDesc = findViewById(R.id.textDetailsDesc);
        textDetailsDesc.setText(desc);

<<<<<<< HEAD
        TextView textDetailsWebsite = findViewById(R.id.textDetailsWebsite);
        textDetailsWebsite.setText(website);

=======
        TextView textDetailsRating = findViewById(R.id.textDetailsRating);
        textDetailsRating.setText(rating.toString());

        TextView textDetailsLocation = findViewById(R.id.textDetailsLocation);
        textDetailsLocation.setText(location);

        TextView textDetailsWebsite = findViewById(R.id.textDetailsWebsite);
        textDetailsWebsite.setText(website);
        
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c

        //add to list button
        Button addToListBtn = findViewById(R.id.addToListBtn);

        // Set OnClickListener to the button
        addToListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start NewActivity
<<<<<<< HEAD
                Intent intent = new Intent(AttractionDetailsActivity.this, DatePickerActivity.class);
=======
                Intent intent = new Intent(AttractionDetailsActivity.this, addToPlanActivity.class);
                intent.putExtra("id", id);
>>>>>>> 6bc17592a1b04fc939256fae9370749a5eff503c
                startActivity(intent);
            }
        });
    }
}