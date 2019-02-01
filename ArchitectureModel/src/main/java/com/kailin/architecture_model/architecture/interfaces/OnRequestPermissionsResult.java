package com.kailin.architecture_model.architecture.interfaces;

public interface OnRequestPermissionsResult {

    void onPermissionGranted(int requestCode, String[] permissions, int[] grantResults);

    void onPermissionDenied(int requestCode, String[] permissions, int[] grantResults);
}
