package com.example.borodin.tracker_android;

import java.util.ArrayList;
import java.util.List;

public class MyPlane {
    String name;
    String phone;
    List<GeoLocation> geoLocations = new ArrayList<>();

    public MyPlane(String name, String phone, GeoLocation geoLocation) {
        this.name = name;
        this.phone = phone;
        this.geoLocations.add(geoLocation);
    }
}
