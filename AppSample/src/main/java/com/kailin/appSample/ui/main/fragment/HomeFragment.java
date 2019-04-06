package com.kailin.appSample.ui.main.fragment;

import android.os.Bundle;

import com.kailin.appSample.R;
import com.kailin.appSample.databinding.MainHomeFragmentBinding;
import com.kailin.architecture_model.architecture.ArchitectureFragment;

import androidx.annotation.Nullable;

public final class HomeFragment extends ArchitectureFragment<MainHomeFragmentBinding, HomeViewModel> {
    @Override
    public int getLayoutRes() {
        return R.layout.main_home_fragment;
    }

    @Override
    public Class getViewModelClass() {
        return HomeViewModel.class;
    }

    @Override
    public void initBindings() {

    }
}
