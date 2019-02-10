package com.kailin.appSample.ui.main.fragment;

import com.kailin.appSample.R;
import com.kailin.appSample.databinding.MainAppsFragmentBinding;
import com.kailin.architecture_model.architecture.ArchitectureFragment;

public final class AppsFragment extends ArchitectureFragment<MainAppsFragmentBinding, AppsViewModel> {
    @Override
    public int getLayoutRes() {
        return R.layout.main_apps_fragment;
    }

    @Override
    public Class getViewModelClass() {
        return AppsViewModel.class;
    }

    @Override
    public void initBindings() {

    }
}
