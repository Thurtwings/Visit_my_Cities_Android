/*package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Connexion extends AppCompatActivity {

    private EditText pseudo;
    private EditText motdepasse;
    private Button seConnecter;
    private Button Inscription;
    private DBManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.LoginScreen);
        seConnecter = (Button) findViewById(R.id.UserScreenButton);
        pseudo = (EditText) findViewById(R.id.editTextPseudo);
        motdepasse = (EditText) findViewById(R.id.editTextPassword);
        Inscription = (Button) findViewById(R.id.SignupScreenButton);
        databaseManager = new DBManager(getApplicationContext());

        seConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectUser();  // appeler la méthode connectUser()
            }
        });

        Inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Connexion.this, SignUpScreen.class);
                startActivity(i);
            }
        });
    }

    public void connectUser() {
        String url = "http://jdevalik.fr/api/cities/qry/getusers.php";

        Map<String, String> params = new HashMap<>();
        params.put("pseudo", pseudo.getText().toString());
        params.put("password", motdepasse.getText().toString());
        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest JsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, parameters, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(), "Connexion réussi",Toast.LENGTH_LONG).show();

                // Ajout de navigation vers la page d'inscription
                Intent i = new Intent(Connexion.this, UserProfileScreen.class);
                startActivity(i);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });

        databaseManager.queue.add(JsonObjectRequest);
    }

}
*/