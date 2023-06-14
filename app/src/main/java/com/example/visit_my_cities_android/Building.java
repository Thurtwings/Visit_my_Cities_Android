package com.example.visit_my_cities_android;

public class Building {
    private int buildingId;
    private String buildingName;
    private String buildingAddress;
    private String buildingPhotoUrl;
    private String buildingDescription;

    public Building(int buildingId, String buildingName, String buildingAddress, String buildingPhotoUrl, String buildingDescription) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.buildingAddress = buildingAddress;
        this.buildingPhotoUrl = buildingPhotoUrl;
        this.buildingDescription = buildingDescription;
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

    public String getBuildingDescription() {
        return buildingDescription;
    }
}


