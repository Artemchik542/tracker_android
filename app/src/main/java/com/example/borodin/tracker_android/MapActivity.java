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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        num = getIntent().getIntExtra(PLANE_NAME, 0);//получение позиции аппарата из списка
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;//создаие катры

        LatLng plane1 = new LatLng(PLANES.get(num).geoLocations.get(num).latitude,
                PLANES.get(num).geoLocations.get(0).longitude);//создание объекта для отрисовки
        mMap.addMarker(new MarkerOptions().position(plane1).title(PLANES.get(num).name));//добавление маркера на карте
        mMap.moveCamera(CameraUpdateFactory.newLatLng(plane1));
    }

}
