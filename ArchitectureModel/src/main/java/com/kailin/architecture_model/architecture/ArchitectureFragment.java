package com.kailin.architecture_model.architecture;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kailin.architecture_model.architecture.interfaces.ArchitectureInterface;
import com.kailin.architecture_model.architecture.interfaces.FragmentInterface;
import com.kailin.architecture_model.architecture.interfaces.OnRequestPermissionsResult;
import com.kailin.architecture_model.architecture.interfaces.PermissionInterface;
import com.kailin.architecture_model.architecture.interfaces.ReceiverInterface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public abstract class ArchitectureFragment<B extends ViewDataBinding, VM extends ViewModel>
        extends Fragment implements PermissionInterface, ReceiverInterface, ArchitectureInterface<VM>, FragmentInterface {

    protected B binding;
    protected VM viewModel;
    protected Context context;
    protected PermissionInterface permissionInterface;
    protected FragmentInterface fragmentInterface;
    protected ReceiverInterface receiverInterface;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(getViewModelClass());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        }
        if (context instanceof PermissionInterface) {
            permissionInterface = (PermissionInterface) context;
        }
        if (context instanceof ReceiverInterface) {
            receiverInterface = (ReceiverInterface) context;
        }
        initBindings();
    }

    @Override
    public void checkPermission(OnRequestPermissionsResult permissionListener, int requestCode, String... permissions) {
        permissionInterface.checkPermission(permissionListener, requestCode, permissions);
    }

    @Override
    public void registerReceiver(BroadcastReceiver receiver, String... actions) {
        receiverInterface.registerReceiver(receiver, actions);
    }

    @Override
    public void unRegisterReceiver(BroadcastReceiver receiver) {
        receiverInterface.unRegisterReceiver(receiver);
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        fragmentInterface.replaceFragment(fragment);
    }

    @Override
    public void replaceFragment(Fragment fragment, String TAG) {
        fragmentInterface.replaceFragment(fragment, TAG);
    }

    @Override
    public void replaceFragment(int layoutId, Fragment fragment, String TAG) {
        fragmentInterface.replaceFragment(layoutId, fragment, TAG);
    }

    @Override
    public void addFragment(Fragment fragment) {
        fragmentInterface.addFragment(fragment);
    }

    @Override
    public void addFragment(Fragment fragment, String TAG) {
        fragmentInterface.addFragment(fragment, TAG);
    }

    @Override
    public void addFragment(int layoutId, Fragment fragment, String TAG) {
        fragmentInterface.addFragment(layoutId, fragment, TAG);
    }

    @Override
    public void popFragment() {
        fragmentInterface.popFragment();
    }

    @Override
    public int getContainerViewId() {
        return fragmentInterface.getContainerViewId();
    }
}
