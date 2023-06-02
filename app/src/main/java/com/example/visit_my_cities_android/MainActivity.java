package com.example.visit_my_cities_android;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity{


    private Button homeScreenMapButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeScreenMapButton = (Button) findViewById(R.id.HomeScreenMapButton);
        homeScreenMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMapScreen();
            }
        });

    }

    private void GoToMapScreen()
    {
        Intent nav = new Intent(this, MapDisplay.class);
        startActivity(nav);
    }


}