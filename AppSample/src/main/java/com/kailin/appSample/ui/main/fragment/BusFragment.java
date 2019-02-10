package com.kailin.appSample.ui.main.fragment;

import com.kailin.appSample.R;
import com.kailin.appSample.databinding.MainBusFragmentBinding;
import com.kailin.architecture_model.architecture.ArchitectureFragment;

public final class BusFragment extends ArchitectureFragment<MainBusFragmentBinding, BusViewModel> {

    @Override
    public int getLayoutRes() {
        return R.layout.main_bus_fragment;
    }

    @Override
    public Class getViewModelClass() {
        return BusViewModel.class;
    }

    @Override
    public void initBindings() {

    }
}
