package com.kailin.architecture_model.architecture.interfaces;

import androidx.lifecycle.ViewModel;

public interface ArchitectureInterface<VM extends ViewModel> {

    int getLayoutRes();

    Class<VM> getViewModelClass();

    void initBindings();
}
