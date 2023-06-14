package com.example.visit_my_cities_android;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        recyclerView = findViewById(R.id.buildingRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buildingList = new ArrayList<>();
        buildingAdapter = new BuildingAdapter(buildingList);
        recyclerView.setAdapter(buildingAdapter);

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

                            // Create a Building object and add it to the list
                            Building building = new Building(buildingId, buildingName, buildingAddress, buildingPhotoUrl);
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
                        GoToBuildingDetails(building.getBuildingId());
                    }
                });
            }
        }
    }

    private void GoToBuildingDetails(int buildingId) {
        // Handle navigation to building details screen
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
