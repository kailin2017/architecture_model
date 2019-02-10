package com.kailin.appSample.util;

import android.content.Context;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

public final class LocationUtil {


    private final FusedLocationProviderClient fusedLocationProviderClient;

    public LocationUtil(Context context) {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
    }
}
