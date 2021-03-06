package com.kailin.sample.base;

import com.example.a116301.myapplication.R;
import com.kailin.architecture_model.architecture.ArchitectureActivity;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

public abstract class BaseActivity<B extends ViewDataBinding, VM extends ViewModel> extends ArchitectureActivity<B, VM> {

    @Override
    public int getContainerViewId() {
        return R.id.fragment_layout;
    }
}
