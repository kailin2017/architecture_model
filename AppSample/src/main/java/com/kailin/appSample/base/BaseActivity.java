package com.kailin.appSample.base;

import com.kailin.architecture_model.architecture.ArchitectureActivity;
import com.kailin.architecture_model.architecture.ArchitectureViewModel;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

public abstract class BaseActivity<B extends ViewDataBinding, VM extends ArchitectureViewModel> extends ArchitectureActivity<B, VM> {
}
