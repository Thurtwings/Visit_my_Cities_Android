package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    private DBManager databaseManager;

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

    public void createUser() {
        String url = "http://jdevalik.fr/api/VMC_PHP_SBG/vmc_insertuser.php";

        String pseudo = editTextPseudo2.getText().toString();
        String email = editTextMail2.getText().toString();
        String password = editTextPassword2.getText().toString();

        if(pseudo.isEmpty() || email.isEmpty() || password.isEmpty()) {
            // Show an error if any of the fields are empty
            Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs", Toast.LENGTH_LONG).show();
            return;
        }

        Map<String, String> params = new HashMap<>();
        params.put("utilisateur_pseudo", pseudo);
        params.put("utilisateur_email", email);
        params.put("utilisateur_mdp", password);
        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, parameters, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    boolean success = response.getBoolean("success");
                    if (success) {
                        // Sign up successful
                        Toast.makeText(getApplicationContext(), "Inscription réussie", Toast.LENGTH_LONG).show();
                        Intent nav = new Intent(SignUpScreen.this, UserProfileScreen.class);
                        startActivity(nav);
                    } else {
                        // Sign up failed
                        Toast.makeText(getApplicationContext(), "L'inscription a échoué", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Erreur de réponse du serveur", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Erreur de connexion", Toast.LENGTH_LONG).show();
            }
        });

        databaseManager.queue.add(jsonObjectRequest);
    }

}