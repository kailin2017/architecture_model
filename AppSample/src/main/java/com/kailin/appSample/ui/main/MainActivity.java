package com.kailin.appSample.ui.main;

import android.Manifest;

import com.kailin.appSample.R;
import com.kailin.appSample.base.BaseActivity;
import com.kailin.appSample.databinding.MainActivityBinding;

import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends BaseActivity<MainActivityBinding, MainViewModel> {

    @Override
    public int getLayoutRes() {
        return R.layout.main_activity;
    }

    @Override
    public Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }

    @Override
    public void initBindings() {
        setSupportActionBar(binding.coordinator.toolbar);

        NavHostFragment hostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navigationFragment);
        NavigationUI.setupWithNavController(binding.bottomNavigationView, hostFragment.getNavController());
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPermission(0, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION);
    }

    @Override
    public void onPermissionGranted(int requestCode, String[] permissions, int[] grantResults) {
        viewModel.getBusVersion();
    }

    @Override
    public void onPermissionDenied(int requestCode, String[] permissions, int[] grantResults) {
        finish();
    }
}
