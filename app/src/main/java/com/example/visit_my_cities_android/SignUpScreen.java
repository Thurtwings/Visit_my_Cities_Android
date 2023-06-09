package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUpScreen extends AppCompatActivity {

    private ImageView background5;
    private ImageView banniere5;

    private TextView textViewPseudo2;
    private TextView textViewMail2;
    private TextView textViewPassword2;

    private EditText editTextPseudo2;
    private EditText editTextMail2;
    private EditText editTextPassword2;

    private ImageButton addAvatarButton;

    private ImageButton userScreenButton2;
    private ImageButton LoginButton;

    private ImageButton mapButton5;
    private ImageButton buildingButton5;
    private ImageButton addButton5;
    private ImageButton accountButton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        background5 = (ImageView) findViewById(R.id.background5);
        banniere5 = (ImageView) findViewById(R.id.banniere5);


        textViewPseudo2 = (TextView) findViewById(R.id.textViewPseudo2);
        textViewMail2 = (TextView) findViewById(R.id.textViewMail2);
        textViewPassword2 = (TextView) findViewById(R.id.textViewPassword2);

        editTextPseudo2 = (EditText) findViewById(R.id.editTextPseudo2);
        editTextMail2 = (EditText) findViewById(R.id.editTextMail2);
        editTextPassword2 = (EditText) findViewById(R.id.editTextPassword2);


        addAvatarButton = (ImageButton) findViewById(R.id.addAvatarButton);
        userScreenButton2 = (ImageButton) findViewById(R.id.userScreenButton2);
        LoginButton = (ImageButton) findViewById(R.id.LoginButton);



        mapButton5 = (ImageButton) findViewById(R.id.mapButton5);
        buildingButton5 = (ImageButton) findViewById(R.id.buildingButton5);
        addButton5 = (ImageButton) findViewById(R.id.addButton5);
        accountButton5 = (ImageButton) findViewById(R.id.accountButton5);



        mapButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMapScreen();
            }
        });

        buildingButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToFeedScreen();
            }
        });

        addButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToListsScreen();
            }
        });

        userScreenButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToProfile();
            }
        });

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToLogin();
            }
        });
    }


    private void GoToLogin()
    {
        Intent nav = new Intent(this, LoginScreen.class);
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