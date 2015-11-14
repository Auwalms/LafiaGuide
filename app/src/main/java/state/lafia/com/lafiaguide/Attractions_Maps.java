package state.lafia.com.lafiaguide;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Attractions_Maps extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions__maps);
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

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
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

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(8.504239, 8.544522)).title("Lafia Government House").icon(BitmapDescriptorFactory.fromResource(R.drawable.attractionm)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(8.498912, 8.516583)).title("Attraction").icon(BitmapDescriptorFactory.fromResource(R.drawable.attractionm)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(8.496817, 8.517124)).title("Parade Ground") .icon(BitmapDescriptorFactory.fromResource(R.drawable.attractionm)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(8.490349, 8.512684)).title("Emirs Palace") .icon(BitmapDescriptorFactory.fromResource(R.drawable.attractionm)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(8.490530, 8.511849)).title("Massalacin Jummuah").icon(BitmapDescriptorFactory.fromResource(R.drawable.attractionm)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(8.502477, 8.519337)).title("St. Williams Cathedral Church").icon(BitmapDescriptorFactory.fromResource(R.drawable.attractionm)));
    }
}
