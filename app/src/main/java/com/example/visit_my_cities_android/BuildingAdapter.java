package com.example.visit_my_cities_android;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BuildingAdapter extends RecyclerView.Adapter<BuildingAdapter.BuildingViewHolder> {

    private List<Building> buildingList;
    private Context context;

    public BuildingAdapter(List<Building> buildingList, Context context) {
        this.buildingList = buildingList;
        this.context = context;
    }

    @NonNull
    @Override
    public BuildingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.building_row_layout, parent, false);
        return new BuildingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuildingViewHolder holder, int position) {
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
            Intent intent = new Intent(context, BuildingDetailsScreen.class);
            intent.putExtra("buildingId", buildingId);
            context.startActivity(intent);
        }
    }
}
