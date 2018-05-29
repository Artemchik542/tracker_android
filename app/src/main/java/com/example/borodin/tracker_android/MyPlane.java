package com.example.borodin.tracker_android;

import java.util.ArrayList;
import java.util.List;

public class MyPlane {
    String name;
    String phone;
    public List<GeoLocation> geoLocations = new ArrayList<>();

    public MyPlane(String name, String phone, GeoLocation geoLocation) {
        this.name = name;
        this.phone = phone;
        this.geoLocations.add(geoLocation);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


