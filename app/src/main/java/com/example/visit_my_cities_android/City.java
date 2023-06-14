package com.example.visit_my_cities_android;

public class City {
    private int cityId;
    private String cityName;


    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;

    }

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

}
