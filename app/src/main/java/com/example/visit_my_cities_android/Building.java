package com.example.visit_my_cities_android;

public class Building {
    private int buildingId;
    private String buildingName;
    private String buildingAddress;
    private String buildingPhotoUrl;

    public Building(int buildingId, String buildingName, String buildingAddress, String buildingPhotoUrl) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.buildingAddress = buildingAddress;
        this.buildingPhotoUrl = buildingPhotoUrl;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public String getBuildingPhotoUrl() {
        return buildingPhotoUrl;
    }
}

