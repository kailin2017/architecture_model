package com.kailin.sample.main;

import com.example.a116301.myapplication.R;
import com.example.a116301.myapplication.databinding.MainFragmentBinding;
import com.kailin.architecture_model.architecture.ArchitectureFragment;

public class MainFragment extends ArchitectureFragment<MainFragmentBinding, MainViewModel> {

    public static MainFragment getInstance(){
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
        viewModel.newUser();
    }
}
