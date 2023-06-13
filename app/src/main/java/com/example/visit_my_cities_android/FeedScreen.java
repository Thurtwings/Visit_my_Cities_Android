package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;


public class
FeedScreen extends AppCompatActivity {

    private ImageView background2;
    private ImageView banniere2;

    private TextView nom2;
    private ImageView imageIllustration2;
    private ImageButton VisitMonumentButton;

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


        nom2 = (TextView) findViewById(R.id.nom3);

        imageIllustration2 = (ImageView) findViewById(R.id.imageIllustration3);

        VisitMonumentButton = (ImageButton) findViewById(R.id.VisitMonumentButton);


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

    /*public void DisplayAllBuildings()
    {
        String url = "http://jdevalik.fr/api/VMC_PHP_SBG/vmc_get_buildings_sbg.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        });
    }*/
}