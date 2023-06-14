package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BuildingDetailsScreen extends AppCompatActivity {

    ImageView background_detail_building;
    ImageView banniere_detail_building;

    ImageButton btn_return_detail_monument;
    ImageButton btn_add_favori_detail_monument;

    ImageView buildingPicture;
    TextView buildingName;
    TextView buildingDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_details_screen);

        background_detail_building = (ImageView) findViewById(R.id.background_detail_building);
        banniere_detail_building = (ImageView) findViewById(R.id.banniere_detail_building);

        btn_return_detail_monument = (ImageButton) findViewById(R.id.btn_return_detail_monument);
        btn_add_favori_detail_monument = (ImageButton) findViewById(R.id.btn_add_favori_detail_monument);


        buildingPicture = findViewById(R.id.BuildingPicture);
        buildingName = findViewById(R.id.BuildingName);
        buildingDescription = findViewById(R.id.BuildingDescription);

        // Get the building details from the intent or any other source
        int buildingId = getIntent().getIntExtra("buildingId", 0);
        String buildingName = getIntent().getStringExtra("buildingName");
        String buildingDescription = getIntent().getStringExtra("buildingDescription");
        String imageUrl = getIntent().getStringExtra("imageUrl");
        FillUpDetails(buildingId, buildingName, buildingDescription, imageUrl);

        btn_return_detail_monument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReturnScreen();
            }
        });

        btn_add_favori_detail_monument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddToFavoriList();
            }
        });

    }

    private void ReturnScreen()
    {
        Intent nav = new Intent(this, FeedScreen.class);
        startActivity(nav);
    }

    private void AddToFavoriList()
    {
        Intent nav = new Intent(this, UserProfileScreen.class);
        startActivity(nav);
    }

    private void FillUpDetails(int buildingId, String name, String description, String imageUrl) {
        // Set the building picture, name, and description in the corresponding views
        Picasso.get().load(imageUrl).placeholder(R.drawable.placeholder).into(buildingPicture);
        buildingName.setText(name);
        buildingDescription.setText(description);
    }
}
