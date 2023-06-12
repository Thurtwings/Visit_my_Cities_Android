package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



public class UserProfileScreen extends AppCompatActivity
{

    private ImageView background6;
    private ImageView banniere6;

    private TextView textViewPseudo_UPS;
    private TextView textViewMail_UPS;
    private TextView textViewEmail_UPS;
    private TextView textViewMotDePasse_UPS;
    private TextView textViewPassWord_UPS;

    private ImageButton deconnectButton_UPS;

    private ImageButton favoriListButton_UPS;

    private ImageButton mapButton_UPS;
    private ImageButton buildingButton_UPS;
    private ImageButton addButton_UPS;
    private ImageButton accountButton_UPS;

    UserDataHandler dbHandler = new UserDataHandler(this);

    public static String CurrentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_screen);

        background6 = (ImageView) findViewById(R.id.background6);
        banniere6 = (ImageView) findViewById(R.id.banniere6);

        //UPS = UserProfileScreen 
        textViewPseudo_UPS = (TextView) findViewById(R.id.textViewPseudo3);
        textViewMail_UPS = (TextView) findViewById(R.id.textViewMail3);
        textViewEmail_UPS = (TextView) findViewById(R.id.textViewEmail);
        textViewMotDePasse_UPS = (TextView) findViewById(R.id.textViewPassword3);
        textViewPassWord_UPS = (TextView) findViewById(R.id.textViewPassWord);


        deconnectButton_UPS = (ImageButton) findViewById(R.id.deconnectButton);
        favoriListButton_UPS = (ImageButton) findViewById(R.id.favoriListButton);


        mapButton_UPS = (ImageButton) findViewById(R.id.mapButton6);
        buildingButton_UPS = (ImageButton) findViewById(R.id.buildingButton6);
        addButton_UPS = (ImageButton) findViewById(R.id.addButton6);
        accountButton_UPS = (ImageButton) findViewById(R.id.accountButton6);



        mapButton_UPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMapScreen();
            }
        });

        buildingButton_UPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToFeedScreen();
            }
        });

        addButton_UPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToListsScreen();
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
}