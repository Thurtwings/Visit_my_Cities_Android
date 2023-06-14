package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BuildingDetailsScreen extends AppCompatActivity {

    ImageView buildingPicture;
    TextView buildingName;
    TextView buildingDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_details_screen);

        buildingPicture = findViewById(R.id.BuildingPicture);
        buildingName = findViewById(R.id.BuildingName);
        buildingDescription = findViewById(R.id.BuildingDescription);

        // Get the building details from the intent or any other source
        int buildingId = getIntent().getIntExtra("buildingId", 0);
        String buildingName = getIntent().getStringExtra("buildingName");
        String buildingDescription = getIntent().getStringExtra("buildingDescription");
        String imageUrl = getIntent().getStringExtra("imageUrl");
        FillUpDetails(buildingId, buildingName, buildingDescription, imageUrl);

    }

    private void FillUpDetails(int buildingId, String name, String description, String imageUrl) {
        // Set the building picture, name, and description in the corresponding views
        Picasso.get().load(imageUrl).placeholder(R.drawable.placeholder).into(buildingPicture);
        buildingName.setText(name);
        buildingDescription.setText(description);
    }
}
