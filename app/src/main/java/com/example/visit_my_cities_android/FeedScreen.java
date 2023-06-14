package com.example.visit_my_cities_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FeedScreen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BuildingAdapter buildingAdapter;
    private List<Building> buildingList;
    private ImageView background2;
    private ImageView banniere2;

    private ImageButton mapButton2;
    private ImageButton buildingButton2;
    private ImageButton addButton2;
    private ImageButton accountButton2;

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

        recyclerView = findViewById(R.id.buildingRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buildingList = new ArrayList<>();
        buildingAdapter = new BuildingAdapter(buildingList);
        recyclerView.setAdapter(buildingAdapter);

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

        fetchBuildings();
    }

    private void fetchBuildings() {
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
                            String buildingPhotoUrl = buildingObject.getString("batiment_lien_photo");
                            String buildingDescription = buildingObject.getString("batiment_decription");

                            // Create a Building object and add it to the list
                            Building building = new Building(buildingId, buildingName, buildingAddress, buildingPhotoUrl, buildingDescription);
                            buildingList.add(building);
                        }

                        buildingAdapter.notifyDataSetChanged();
                    } else {
                        String message = jsonResponse.getString("message");
                        // Handle the failure case
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    // Handle JSON parsing error
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error response
            }
        });

        // Add the request to the Volley request queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private class BuildingAdapter extends RecyclerView.Adapter<BuildingAdapter.BuildingViewHolder> {

        private List<Building> buildingList;

        public BuildingAdapter(List<Building> buildingList) {
            this.buildingList = buildingList;
        }

        @Override
        public BuildingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.building_row_layout, parent, false);
            return new BuildingViewHolder(view);
        }

        @Override
        public void onBindViewHolder(BuildingViewHolder holder, int position) {
            Building building = buildingList.get(position);
            holder.bind(building);
        }

        @Override
        public int getItemCount() {
            return buildingList.size();
        }

        public class BuildingViewHolder extends RecyclerView.ViewHolder {

            private ImageView imageIllustration;
            private TextView nom;

            public BuildingViewHolder(View itemView) {
                super(itemView);
                imageIllustration = itemView.findViewById(R.id.imageIllustration3);
                nom = itemView.findViewById(R.id.nom3);
            }

            public void bind(Building building) {
                nom.setText(building.getBuildingName());
                Picasso.get().load(building.getBuildingPhotoUrl()).into(imageIllustration);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Handle building row click event
                        GoToBuildingDetails(getAdapterPosition());
                    }
                });
            }
        }
    }

    private void GoToBuildingDetails(int position) {
        Building building = buildingList.get(position);
        Intent nav = new Intent(this, BuildingDetailsScreen.class);
        nav.putExtra("buildingId", building.getBuildingId());
        nav.putExtra("buildingName", building.getBuildingName());
        nav.putExtra("buildingDescription", building.getBuildingDescription());
        nav.putExtra("imageUrl", building.getBuildingPhotoUrl());
        startActivity(nav);
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
}
