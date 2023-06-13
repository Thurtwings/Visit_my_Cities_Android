package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedScreen extends AppCompatActivity {

    private ImageView background2;
    private ImageView banniere2;
    private ImageButton mapButton2;
    private ImageButton buildingButton2;
    private ImageButton addButton2;
    private ImageButton accountButton2;
    private TableLayout buildingContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        background2 = findViewById(R.id.background2);
        banniere2 = findViewById(R.id.banniere2);
        mapButton2 = findViewById(R.id.mapButton2);
        buildingButton2 = findViewById(R.id.buildingButton2);
        addButton2 = findViewById(R.id.addButton2);
        accountButton2 = findViewById(R.id.accountButton2);
        buildingContainer = findViewById(R.id.buildingContainer);

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

        DisplayAllBuildings();
    }


    private void GoToBuildingDetails(int buildingId, String buildingName, String buildingAddress, String imageUrl) {
        Intent intent = new Intent(FeedScreen.this, BuildingDetailsScreen.class);
        intent.putExtra("buildingId", buildingId);
        intent.putExtra("buildingName", buildingName);
        intent.putExtra("buildingAddress", buildingAddress);
        intent.putExtra("imageUrl", imageUrl);
        startActivity(intent);
    }


    private void GoToMapScreen() {
        Intent nav = new Intent(this, MapScreen.class);
        startActivity(nav);
    }

    private void GoToListsScreen() {
        Intent nav = new Intent(this, ListsScreen.class);
        startActivity(nav);
    }

    private void GoToLoginScreen() {
        Intent nav = new Intent(this, LoginScreen.class);
        startActivity(nav);
    }

    public void DisplayAllBuildings() {
        String url = "http://jdevalik.fr/api/VMC_PHP_SBG/vmc_get_buildings_sbg.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        JSONArray buildingsArray = jsonResponse.getJSONArray("batiments");

                        for (int i = 0; i < buildingsArray.length(); i++) {
                            JSONObject buildingObject = buildingsArray.getJSONObject(i);

                            // Extract the building details from the JSON object
                            int buildingId = buildingObject.getInt("batiment_id");
                            String buildingName = buildingObject.getString("batiment_nom");
                            String buildingAddress = buildingObject.getString("batiment_adresse");
                            String imageUrl = buildingObject.getString("batiment_lien_photo");

                            // Generate the XML code for the building
                            processBuildingXml(buildingId, buildingName, buildingAddress, imageUrl);
                        }
                    } else {
                        String message = jsonResponse.getString("message");
                        // Handle the failure case
                        handleError(message);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    // Handle JSON parsing error
                    handleError("JSON parsing error");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error response
                handleError(error.getMessage());
            }
        });

        // Add the request to the Volley request queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void handleError(String errorMessage) {
        // Display or handle the error message as needed
        Toast.makeText(FeedScreen.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
    }

    private void processBuildingXml(int buildingId, String buildingName, String buildingAddress, String imageUrl) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View buildingView = inflater.inflate(R.layout.building_row_layout, buildingContainer, false);

        // Set the building details in the inflated view
        TextView nom3 = buildingView.findViewById(R.id.nom3);
        nom3.setText(buildingName);

        ImageView imageIllustration3 = buildingView.findViewById(R.id.imageIllustration3);
        Picasso.get().load(imageUrl).placeholder(R.drawable.placeholder).into(imageIllustration3);

        // Set click listener to the building row
        buildingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle building row click event
                GoToBuildingDetails(buildingId, buildingName, buildingAddress, imageUrl);
            }
        });

        buildingContainer.addView(buildingView);
    }


}
