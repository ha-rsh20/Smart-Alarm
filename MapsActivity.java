package com.example.testmap;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.testmap.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{
//
    Button btnShowLocation;
    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    GPSTracker gps;
    GoogleMap googleMap;
    PackageManager MockPackageManager;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.testmap.databinding.ActivityMapsBinding binding = ActivityMapsBinding.inflate(getLayoutInflater());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(binding.getRoot());

        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission)
                    != MockPackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        onMapReady(googleMap);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //gps = new GPSTracker(MapsActivity.this);

        /*if(true){
            double latitude = 22.2587 ;//gps.getLatitude();
            double longitude = 71.1924 ;//gps.getLongitude();
            LatLng user_loc = new LatLng(latitude, longitude);
            googleMap.addMarker(new MarkerOptions().position(user_loc).title("You are here"));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(user_loc,10),2500,null);
        }else{
            gps.showSettingsAlert();
        }*/
        Toast.makeText(getApplicationContext(), "Your Location is - \nLat: "
                + "\nLong: ", Toast.LENGTH_LONG).show();
        LatLng loc = new LatLng(22.2587,71.1924);
        //googleMap.addMarker(new MarkerOptions().position(loc).title("You are here"));
        //googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc,10),2500,null);
    }
}