package com.kailin.architecture_model.architecture.interfaces;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;

public interface FragmentInterface {

    void replaceFragment(Fragment fragment);

    void replaceFragment(Fragment fragment, String TAG);

    void replaceFragment(@IdRes int layoutId, Fragment fragment, String TAG);

    void addFragment(Fragment fragment);

    void addFragment(Fragment fragment, String TAG);

    void addFragment(@IdRes int layoutId, Fragment fragment, String TAG);

    void popFragment();

    @IdRes
    int getContainerViewId();
}
