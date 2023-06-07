package com.example.visit_my_cities_android;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{

    private ImageView background;
    private ImageView banniere;
    private ImageView imageNavbar;

    private TextView nom1;
    private ImageView imageIllustration1;
    private ImageButton buttonNom1;

    private ImageButton homeButton;
    private ImageButton mapButton;
    private ImageButton buildingButton;
    private ImageButton addButton;
    private ImageButton accountButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        background = (ImageView) findViewById(R.id.background);
        banniere = (ImageView) findViewById(R.id.banniere);
        imageNavbar = (ImageView) findViewById(R.id.imageNavbar);


        nom1 = (TextView) findViewById(R.id.nom1);

        imageIllustration1 = (ImageView) findViewById(R.id.imageIllustration1);

        buttonNom1 = (ImageButton) findViewById(R.id.buttonNom1);


        homeButton = (ImageButton) findViewById(R.id.homeButton);
        mapButton = (ImageButton) findViewById(R.id.mapButton);
        buildingButton = (ImageButton) findViewById(R.id.buildingButton);
        addButton = (ImageButton) findViewById(R.id.addButton);
        accountButton = (ImageButton) findViewById(R.id.accountButton);


        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMapScreen();
            }
        });

        buildingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToFeedScreen();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToListsScreen();
            }
        });

        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToLoginScreen();
            }
        });
    }


    private void GoToMapScreen()
    {
        Intent nav = new Intent(this, MapScreen.class);
        startActivity(nav);
    }

    private void GoToFeedScreen()
    {
        Intent nav = new Intent(this, FeedScreen.class);
        startActivity(nav);
    }

    private void GoToListsScreen()
    {
        Intent nav = new Intent(this, ListsScreen.class);
        startActivity(nav);
    }

    private void GoToLoginScreen()
    {
        Intent nav = new Intent(this, LoginScreen.class);
        startActivity(nav);
    }
}