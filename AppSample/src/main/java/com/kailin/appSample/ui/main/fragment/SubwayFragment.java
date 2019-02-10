package com.kailin.appSample.ui.main.fragment;

import com.kailin.appSample.R;
import com.kailin.appSample.databinding.MainSubwayFragmentBinding;
import com.kailin.architecture_model.architecture.ArchitectureFragment;

public final class SubwayFragment extends ArchitectureFragment<MainSubwayFragmentBinding, SubwayViewModel> {
    @Override
    public int getLayoutRes() {
        return R.layout.main_subway_fragment;
    }

    @Override
    public Class getViewModelClass() {
        return SubwayViewModel.class;
    }

    @Override
    public void initBindings() {

    }
}
