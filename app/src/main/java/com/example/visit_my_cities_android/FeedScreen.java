package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class FeedScreen extends AppCompatActivity {

    private ImageView background2;
    private ImageView banniere2;
    private ImageView imageNavbar2;

    private TextView nom2;
    private ImageView imageIllustration2;
    private Button buttonNom2;

    private ImageButton mapButton2;
    private ImageButton buildingButton2;
    private ImageButton addButton2;
    private ImageButton accountButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        background2 = (ImageView) findViewById(R.id.background2);
        banniere2 = (ImageView) findViewById(R.id.banniere2);
        imageNavbar2 = (ImageView) findViewById(R.id.imageNavbar2);


        nom2 = (TextView) findViewById(R.id.nom3);

        imageIllustration2 = (ImageView) findViewById(R.id.imageIllustration3);

        buttonNom2 = (Button) findViewById(R.id.buttonNom3);


        mapButton2 = (ImageButton) findViewById(R.id.mapButton2);
        buildingButton2 = (ImageButton) findViewById(R.id.buildingButton2);
        addButton2 = (ImageButton) findViewById(R.id.addButton2);
        accountButton2 = (ImageButton) findViewById(R.id.accountButton2);


        mapButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMapScreen();
            }
        });

        addButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToListsScreen();
            }
        });

        accountButton2.setOnClickListener(new View.OnClickListener() {
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