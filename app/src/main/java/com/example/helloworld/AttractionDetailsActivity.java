package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
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


        // Get data from the intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        String desc = intent.getStringExtra("Description");
        String rating = intent.getStringExtra("Rating");
        String distance = intent.getStringExtra("Distance");
        String website = intent.getStringExtra("Website");

        // Set data to views on the details page
        TextView textDetailsTitle = findViewById(R.id.textDetailsTitle);
        textDetailsTitle.setText(title);

        TextView textDetailsDesc = findViewById(R.id.textDetailsDesc);
        textDetailsDesc.setText(desc);

        TextView textDetailsWebsite = findViewById(R.id.textDetailsWebsite);
        textDetailsWebsite.setText(website);


        //add to list button
        Button addToListBtn = findViewById(R.id.addToListBtn);

        // Set OnClickListener to the button
        addToListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start NewActivity
                Intent intent = new Intent(AttractionDetailsActivity.this, DatePickerActivity.class);
                startActivity(intent);
            }
        });
    }
}