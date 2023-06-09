package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginScreen extends AppCompatActivity
{

    private ImageView background4;
    private ImageView banniere4;

    private TextView textViewPseudo;
    private TextView textViewPassword;

    private EditText editTextPseudo;
    private EditText editTextPassword;

    private ImageButton SignupScreenButton;
    private ImageButton UserScreenButton;

    private ImageButton mapButton4;
    private ImageButton buildingButton4;
    private ImageButton addButton4;
    private ImageButton accountButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        background4 = (ImageView) findViewById(R.id.background4);
        banniere4 = (ImageView) findViewById(R.id.banniere4);


        textViewPseudo = (TextView) findViewById(R.id.textViewPseudo);
        textViewPassword = (TextView) findViewById(R.id.textViewPassword);


        SignupScreenButton = (ImageButton) findViewById(R.id.SignupScreenButton);
        UserScreenButton = (ImageButton) findViewById(R.id.UserScreenButton);


        mapButton4 = (ImageButton) findViewById(R.id.mapButton4);
        buildingButton4 = (ImageButton) findViewById(R.id.buildingButton4);
        addButton4 = (ImageButton) findViewById(R.id.addButton4);
        accountButton4 = (ImageButton) findViewById(R.id.accountButton4);


        mapButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMapScreen();
            }
        });

        buildingButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToFeedScreen();
            }
        });

       addButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToListsScreen();
            }
        });

       SignupScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToSignUp();
            }
        });

        UserScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToProfile();
            }
        });
    }

    private void GoToSignUp()
    {
        Intent nav = new Intent(this, SignUpScreen.class);
        startActivity(nav);
    }

    private void GoToProfile()
    {
        Intent nav = new Intent(this, UserProfileScreen.class);
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