package com.kailin.architecture_model.architecture.interfaces;

public interface PermissionInterface {

    void checkPermission( int requestCode, String... permissions);
}
