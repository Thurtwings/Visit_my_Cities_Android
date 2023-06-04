package com.example.visit_my_cities_android;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity
{


    private Button homeScreenMapButton;
    private Button homeScreenLoginButton;
    private Button homeScreenFeedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeScreenMapButton = (Button) findViewById(R.id.HomeScreenMapButton);
        homeScreenLoginButton = (Button) findViewById(R.id.homeScreenConnectButton);
        homeScreenFeedButton = (Button) findViewById(R.id.FeedButton);

        homeScreenMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMapScreen();
            }
        });
        homeScreenLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToLoginScreen();
            }
        });

        homeScreenFeedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToFeedScreen();
            }
        });
    }

    private void GoToFeedScreen()
    {
        Intent nav = new Intent(this, FeedScreen.class);
        startActivity(nav);
    }

    private void GoToLoginScreen()
    {
        Intent nav = new Intent(this, LoginScreen.class);
        startActivity(nav);
    }

    private void GoToMapScreen()
    {
        Intent nav = new Intent(this, MapScreen.class);
        startActivity(nav);
    }


}