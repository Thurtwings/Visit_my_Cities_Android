package com.example.visit_my_cities_android;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

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

        Picasso.get()
                .load(building.getBuildingPhotoUrl())
                .fit()
                .centerCrop()
                .into(imageIllustration);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToBuildingDetails(building.getBuildingId());
            }
        });
    }

    private void GoToBuildingDetails(int buildingId) {
        Intent intent = new Intent(itemView.getContext(), BuildingDetailsScreen.class);
        intent.putExtra("buildingId", buildingId);
        itemView.getContext().startActivity(intent);
    }
}


