package com.example.borodin.tracker_android;



public class GeoLocation{
    Double latitude;
    Double longitude;
    Double height;

    public GeoLocation(Double latitude, Double longitude, Double height) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getHeight() {
        return height;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setHeight(Double height) {
        this.height = height;
    }


}