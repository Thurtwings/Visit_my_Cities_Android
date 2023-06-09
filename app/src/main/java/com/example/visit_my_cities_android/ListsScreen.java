package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ListsScreen extends AppCompatActivity {

    private ImageView background3;
    private ImageView banniere3;

    private TextView nom3;
    private ImageView imageIllustration3;
    private Button buttonNom3;

    private ImageButton mapButton3;
    private ImageButton buildingButton3;
    private ImageButton addButton3;
    private ImageButton accountButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists_screen);

        background3 = (ImageView) findViewById(R.id.background3);
        banniere3 = (ImageView) findViewById(R.id.banniere3);

        nom3 = (TextView) findViewById(R.id.nom3);

        imageIllustration3 = (ImageView) findViewById(R.id.imageIllustration3);

        buttonNom3 = (Button) findViewById(R.id.buttonNom3);


        mapButton3 = (ImageButton) findViewById(R.id.mapButton3);
        buildingButton3 = (ImageButton) findViewById(R.id.buildingButton3);
        addButton3 = (ImageButton) findViewById(R.id.addButton3);
        accountButton3 = (ImageButton) findViewById(R.id.accountButton3);


        mapButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMapScreen();
            }
        });

        buildingButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToFeedScreen();
            }
        });

        accountButton3.setOnClickListener(new View.OnClickListener() {
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

    private void GoToLoginScreen()
    {
        Intent nav = new Intent(this, LoginScreen.class);
        startActivity(nav);
    }

}