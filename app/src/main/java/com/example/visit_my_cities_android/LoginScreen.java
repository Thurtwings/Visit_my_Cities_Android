package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.toolbox.StringRequest;
import com.example.visit_my_cities_android.ConnexionServer.Utilisateur.ConnexionServerGetUsers;

public class LoginScreen extends AppCompatActivity
{

    private ImageView background_LoginScreen;
    private ImageView banniere_LoginScreen;
    private ImageView imageNavbar_LoginScreen;



    private TextView textViewPseudo_LoginScreen;
    private TextView textViewPassword_LoginScreen;

    private EditText editTextPseudo;
    private EditText editTextPassword;

    private ImageButton SignupScreenButton_LoginScreen;
    private ImageButton UserScreenButton_LoginScreen;

    private ImageButton homeButton_LoginScreen;
    private ImageButton mapButton_LoginScreen;
    private ImageButton buildingButton_LoginScreen;
    private ImageButton addButton_LoginScreen;
    private ImageButton accountButton_LoginScreen;


    private DBManager databaseManager;

    private ImageButton mapButton4;
    private ImageButton buildingButton4;
    private ImageButton addButton4;
    private ImageButton accountButton4;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);


        background_LoginScreen = (ImageView) findViewById(R.id.background4);
        banniere_LoginScreen = (ImageView) findViewById(R.id.banniere4);
        imageNavbar_LoginScreen = (ImageView) findViewById(R.id.imageNavbar4);



        textViewPseudo_LoginScreen = (EditText) findViewById(R.id.editTextPseudo);
        textViewPassword_LoginScreen = (EditText) findViewById(R.id.editTextPassword);


        SignupScreenButton_LoginScreen = (ImageButton) findViewById(R.id.SignupScreenButton);
        UserScreenButton_LoginScreen = (ImageButton) findViewById(R.id.UserScreenButton);



        homeButton_LoginScreen = (ImageButton) findViewById(R.id.homeButton4);
        mapButton_LoginScreen = (ImageButton) findViewById(R.id.mapButton4);
        buildingButton_LoginScreen = (ImageButton) findViewById(R.id.buildingButton4);
        addButton_LoginScreen = (ImageButton) findViewById(R.id.addButton4);
        accountButton_LoginScreen = (ImageButton) findViewById(R.id.accountButton4);
        databaseManager = new DBManager(getApplicationContext());
        homeButton_LoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToHomeScreen();
            }
        });


        mapButton_LoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToMapScreen();
            }
        });

        buildingButton_LoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToFeedScreen();
            }
        });

        addButton_LoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToListsScreen();
            }
        });

        SignupScreenButton_LoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToSignUp();
            }
        });

        UserScreenButton_LoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connectUser();
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


    public void connectUser() {
        String url = "http://jdevalik.fr/api/VMC_PHP_SBG/get_pass.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            String success = jsonResponse.getString("success");
                            if (success.equals("true")) {
                                Toast.makeText(getApplicationContext(), "Connexion réussie", Toast.LENGTH_LONG).show();
                                Intent nav = new Intent(LoginScreen.this, UserProfileScreen.class);
                                startActivity(nav);
                            } else {
                                Toast.makeText(getApplicationContext(), "Pseudo ou mot de passe incorrect", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Erreur de réponse du serveur", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Erreur de connexion", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("pseudo", textViewPseudo_LoginScreen.getText().toString());
                params.put("pass", textViewPassword_LoginScreen.getText().toString());
                return params;
            }
        };

        databaseManager.queue.add(stringRequest);
    }

}