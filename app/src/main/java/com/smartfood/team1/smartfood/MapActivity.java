package com.smartfood.team1.smartfood;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(this, "Map Is Ready", Toast.LENGTH_SHORT).show();
        mMap = googleMap;
    }
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;

    private Boolean mLocationPermissionGranted = false;
    private GoogleMap mMap;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        getLocationPermission();
    }
    private void initMap() {
         SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

         mapFragment.getMapAsync(MapActivity.this);
    }

    private void getLocationPermission(){
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionGranted = true;
            }else{
                ActivityCompat.requestPermissions(this,permissions,LOCATION_PERMISSION_REQUEST_CODE);
            }

        }
    }
    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults){
        mLocationPermissionGranted = false;
            if (requestCode ==LOCATION_PERMISSION_REQUEST_CODE ){
                if (grantResults.length > 0){
                       for (int i=0;i<grantResults[i];i++) {
                           if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                               mLocationPermissionGranted = false;
                               break;
                           }
                       }
                    mLocationPermissionGranted = true;
                    // Initialize our map
                    initMap();
                }
            }
        }


}



