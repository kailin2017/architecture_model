package com.kailin.appSample.ui.main.fragment;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kailin.appSample.R;
import com.kailin.appSample.databinding.MainBikeFragmentBinding;
import com.kailin.architecture_model.architecture.ArchitectureFragment;

import androidx.annotation.Nullable;

public final class BikeFragment extends ArchitectureFragment<MainBikeFragmentBinding, BikeViewModel> {

    private MapView mapView;

    @Override
    public int getLayoutRes() {
        return R.layout.main_bike_fragment;
    }

    @Override
    public Class getViewModelClass() {
        return BikeViewModel.class;
    }

    @Override
    public void initBindings() {
        mapView = binding.mapView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this::onMapReady);
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    public void onMapReady(GoogleMap googleMap) {
        LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
