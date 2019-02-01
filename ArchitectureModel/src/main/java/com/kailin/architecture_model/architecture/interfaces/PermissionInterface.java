package com.kailin.architecture_model.architecture.interfaces;

public interface PermissionInterface {

    void checkPermission(OnRequestPermissionsResult permissionListener, int requestCode, String... permissions);
}
