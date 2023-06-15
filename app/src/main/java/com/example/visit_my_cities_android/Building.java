package com.example.visit_my_cities_android;

public class Building {
    private int buildingId;
    private String buildingName;
    private String buildingAddress;
    private String buildingPhotoUrl;
    private String buildingDescription;



    private double buildingLatitude;
    private double buildingLongitude;

    public Building(int buildingId, String buildingName, String buildingAddress, String buildingPhotoUrl, String buildingDescription, double buildingLatitude, double buildingLongitude) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.buildingAddress = buildingAddress;
        this.buildingPhotoUrl = buildingPhotoUrl;
        this.buildingDescription = buildingDescription;
        this.buildingLatitude = buildingLatitude;
        this.buildingLongitude = buildingLongitude;
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

    public double getLatitude() {
        return buildingLatitude;
    }

    public double getLongitude() {
        return buildingLongitude;
    }
}


