package state.lafia.com.lafiaguide;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Hospital_map extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_map);
        setUpMapIfNeeded();
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);


    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }


    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }


    private void setUpMap() {
    mMap.addMarker(new MarkerOptions().position(new LatLng(8.5018818,8.5234863)).title("Dalhatu Araf Specialist Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitalm)));

    mMap.addMarker(new MarkerOptions().position(new LatLng(8.517150, 8.521877)).title("AGU Hosptail lafia").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitalm)));

    mMap.addMarker(new MarkerOptions().position(new LatLng(8.490295, 8.512088)).title("Emirs House Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitalm)));

    }
}
