package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity
{
    private ImageView background;
    private ImageView logoButton;
    //UserDataHandler db = new UserDataHandler(this);

    // Cette méthode est appelée lors de la création de l'activité
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        background = (ImageView) findViewById(R.id.background);
        logoButton = (ImageView) findViewById(R.id.logoButton);
        //db.printUserList();
        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToLoginScreen();
            }
        });

    }

    // Méthode pour aller à l'écran de connexion
    private void GoToLoginScreen()
    {
        Intent nav = new Intent(this, LoginScreen.class);
        startActivity(nav);
    }
}