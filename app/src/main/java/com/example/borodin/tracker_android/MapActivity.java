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

import static com.example.borodin.tracker_android.MainActivity.PLANE;
import static com.example.borodin.tracker_android.MainActivity.PLANES;
import static com.example.borodin.tracker_android.MainActivity.PLANE_NAME;

/**
 * Created by Borodin on 16.05.2018.
 */

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private int num;
    static double Lat = 56.43433434;
    static double Lot = 82.34343434;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        num = getIntent().getIntExtra(PLANE_NAME, 0);




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

        LatLng plane1 = new LatLng(PLANES.get(num).geoLocations.get(num).latitude, PLANES.get(num).geoLocations.get(0).longitude);
        mMap.addMarker(new MarkerOptions().position(plane1).title(PLANES.get(num).name));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(plane1));
    }

}
