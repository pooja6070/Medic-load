package com.android.pharmacy;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.android.pharmacy.clusterRenderer.MarkerClusterRenderer;
import com.android.pharmacy.data.User;
import com.android.pharmacy.util.GoogleMapHelper;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MapActivity extends AppCompatActivity {

    //get instance
    GoogleMap gmap;
    LocationManager locationManager;
    Marker marker;
    LocationListener locationListener;
    private Button btnSearch;
    private EditText editSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_map);
        btnSearch = findViewById(R.id.searchButtonMap);
        editSearch = findViewById(R.id.editPharmacy);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        assert supportMapFragment != null;
        supportMapFragment.getMapAsync(googleMap -> {
            GoogleMapHelper.defaultMapSettings(googleMap);
            setUpClusterManager(googleMap);
            locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    //get the location name from latitude and longitude
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addresses=geocoder.getFromLocation(latitude, longitude, 1);

                        String place = addresses.get(0).getLocality() + ":";

                        place += addresses.get(0).getCountryName();

                        LatLng latLng = new LatLng(latitude, longitude);

                        if (marker != null) {
                            marker.remove();
                            marker = googleMap.addMarker(new MarkerOptions().position(latLng).title(place));
                            googleMap.setMaxZoomPreference(100);
                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13.0f));
                        } else {
                            marker = googleMap.addMarker(new MarkerOptions().position(latLng).title(place));
                            googleMap.setMaxZoomPreference(100);
                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13.0f));
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            };
            btnSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (editSearch.getText().toString() == "ktm pharmacy")
                    {
                        Toast.makeText(MapActivity.this, "pharmacy found !!", Toast.LENGTH_SHORT).show();
                        editSearch.requestFocus();
                        editSearch.setText("");
                    }
                    else {
                        Toast.makeText(MapActivity.this, "pharmacy found !!", Toast.LENGTH_SHORT).show();
                        editSearch.requestFocus();
                        editSearch.setText("");
                    }
                }
            });
        });

    }

    private void setUpClusterManager(GoogleMap googleMap) {
        ClusterManager<User> clusterManager = new ClusterManager<>(this, googleMap);


        MarkerClusterRenderer markerClusterRenderer = new MarkerClusterRenderer(this, googleMap, clusterManager);

        clusterManager.setRenderer(markerClusterRenderer);

        List<User> items = getItems();

        clusterManager.addItems(items);

        clusterManager.cluster();
    }


    private List<User> getItems() {
        return Arrays.asList(
                new User("ktm pharmacy", new LatLng(27.700769, 85.300140), "Maitidevi"),
                new User("saphal pharmacy", new LatLng(27.6971979, 85.3021732), "Dillibazar"),
                new User("mero pharmacy", new LatLng(27.6971379, 85.3021932), "greenland"),
                new User("hamro pharmacy", new LatLng(27.700769, 85.300140), "tokha")

        );
    }

}