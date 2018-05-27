package com.example.borodin.tracker_android;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import static com.example.borodin.tracker_android.MainActivity.PLANE_NAME;

/**
 * Created by Borodin on 16.05.2018.
 */

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String line  = new String();
    static double Lat = 56.43433434;
    static double Lot = 82.34343434;
    List<MyPlane> planes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        line = getIntent().getStringExtra(PLANE_NAME);

        planes.add(new MyPlane("Plane_1", "+1312312312", new GeoLocation( Lat, Lot, 234.34)));
        planes.add(new MyPlane("Plane_2", "+1312312312", new GeoLocation( Lat+5., Lot+5., 234.34)));


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        LatLng plane1 = new LatLng(planes.get(0).geoLocations.get(0).latitude, planes.get(0).geoLocations.get(0).longitude);
        LatLng plane2 = new LatLng(planes.get(1).geoLocations.get(0).latitude, planes.get(1).geoLocations.get(0).longitude);
        mMap.addMarker(new MarkerOptions().position(plane1).title(line));
        mMap.addMarker(new MarkerOptions().position(plane2).title(line));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(plane1));
    }

}
