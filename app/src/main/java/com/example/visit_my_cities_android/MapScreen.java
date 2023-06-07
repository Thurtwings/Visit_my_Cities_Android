package com.example.visit_my_cities_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapScreen extends AppCompatActivity implements OnMapReadyCallback {

    private ImageView banniere1;
    private ImageView imageNavbar1;

    private final int FINE_PERMISSION_CODE = 1;
    private GoogleMap mainMap;
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;

    private ImageButton homeButton1;
    private ImageButton mapButton1;
    private ImageButton buildingButton1;
    private ImageButton addButton1;
    private ImageButton accountButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_display);

        banniere1 = (ImageView) findViewById(R.id.banniere1);
        imageNavbar1 = (ImageView) findViewById(R.id.imageNavbar1);


        homeButton1 = (ImageButton) findViewById(R.id.homeButton1);
        mapButton1 = (ImageButton) findViewById(R.id.mapButton1);
        buildingButton1 = (ImageButton) findViewById(R.id.buildingButton1);
        addButton1 = (ImageButton) findViewById(R.id.addButton1);
        accountButton1 = (ImageButton) findViewById(R.id.accountButton1);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        GetLastLocation();


        homeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToHomeScreen();
            }
        });

        buildingButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToFeedScreen();
            }
        });

        addButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToListsScreen();
            }
        });

        accountButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoToLoginScreen();
            }
        });
    }

    private void GetLastLocation()
    {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, FINE_PERMISSION_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null)
                {
                    currentLocation = location;

                    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                    mapFragment.getMapAsync(MapScreen.this);
                }
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap)
    {
        mainMap = googleMap;

        LatLng user = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        mainMap.addMarker(new MarkerOptions().position(user).title("Ma position"));
        mainMap.moveCamera(CameraUpdateFactory.newLatLng(user));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == FINE_PERMISSION_CODE)
        {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                GetLastLocation();
            }
            else
            {
                Toast.makeText(this, "Permission d'acceder a la localisation refusée, merci de l'autoriser", Toast.LENGTH_SHORT).show();
            }
        }
    }



    private void GoToHomeScreen()
    {
        Intent nav = new Intent(this, MainActivity.class);
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

    private void GoToLoginScreen()
    {
        Intent nav = new Intent(this, LoginScreen.class);
        startActivity(nav);
    }


}