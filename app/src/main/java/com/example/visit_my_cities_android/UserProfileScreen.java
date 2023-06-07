package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class UserProfileScreen extends AppCompatActivity
{

    private ImageView background6;
    private ImageView banniere6;
    private ImageView imageNavbar6;

    private TextView textViewPseudo3;
    private TextView textViewMail3;
    private TextView textViewEmail;
    private TextView textViewPassword3;
    private TextView textViewPassWord;

    private ImageButton deconnectButton;

    private ImageButton favoriAddListButton;
    private ImageButton favoriListButton;

    private ImageButton homeButton6;
    private ImageButton mapButton6;
    private ImageButton buildingButton6;
    private ImageButton addButton6;
    private ImageButton accountButton6;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_screen);

        background6 = (ImageView) findViewById(R.id.background6);
        banniere6 = (ImageView) findViewById(R.id.banniere6);
        imageNavbar6 = (ImageView) findViewById(R.id.imageNavbar6);


        textViewPseudo3 = (TextView) findViewById(R.id.textViewPseudo3);
        textViewMail3 = (TextView) findViewById(R.id.textViewMail3);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewPassword3 = (TextView) findViewById(R.id.textViewPassword3);
        textViewPassWord = (TextView) findViewById(R.id.textViewPassWord);


        deconnectButton = (ImageButton) findViewById(R.id.deconnectButton);
        favoriListButton = (ImageButton) findViewById(R.id.favoriListButton);
        favoriAddListButton = (ImageButton) findViewById(R.id.favoriAddListButton);


        homeButton6 = (ImageButton) findViewById(R.id.homeButton6);
        mapButton6 = (ImageButton) findViewById(R.id.mapButton6);
        buildingButton6 = (ImageButton) findViewById(R.id.buildingButton6);
        addButton6 = (ImageButton) findViewById(R.id.addButton6);
        accountButton6 = (ImageButton) findViewById(R.id.accountButton6);


        homeButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToHomeScreen();
            }
        });

        mapButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMapScreen();
            }
        });

        buildingButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToFeedScreen();
            }
        });

        addButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToListsScreen();
            }
        });

    }

    private void GoToLists()
    {
        Intent nav = new Intent(this, ListsScreen.class);

        startActivity(nav);
    }

    private void GoToFeed()
    {
        Intent nav = new Intent(this, FeedScreen.class);
        startActivity(nav);
    }

    private void GoToHomeScreen()
    {
        Intent nav = new Intent(this, MainActivity.class);
        startActivity(nav);
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
}