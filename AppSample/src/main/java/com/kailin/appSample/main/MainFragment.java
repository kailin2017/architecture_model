package com.kailin.appSample.main;

import android.Manifest;

import com.kailin.appSample.R;
import com.kailin.appSample.databinding.MainFragmentBinding;
import com.kailin.architecture_model.architecture.ArchitectureFragment;
import com.kailin.architecture_model.architecture.interfaces.OnRequestPermissionsResult;

public class MainFragment extends ArchitectureFragment<MainFragmentBinding, MainViewModel> implements OnRequestPermissionsResult {

    public static MainFragment getInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.main_fragment;
    }

    @Override
    public Class getViewModelClass() {
        return MainViewModel.class;
    }

    @Override
    public void initBindings() {
        binding.setViewModel(viewModel);
        checkPermission(this, 0, Manifest.permission.READ_PHONE_STATE);
    }

    @Override
    public void onPermissionGranted(int requestCode, String[] permissions, int[] grantResults) {
        viewModel.newUser(context);
    }

    @Override
    public void onPermissionDenied(int requestCode, String[] permissions, int[] grantResults) {

    }
}
