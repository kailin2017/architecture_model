package com.kailin.architecture_model.architecture;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kailin.architecture_model.architecture.interfaces.ArchitectureInterface;
import com.kailin.architecture_model.architecture.interfaces.FragmentInterface;
import com.kailin.architecture_model.architecture.interfaces.OnRequestPermissionsResult;
import com.kailin.architecture_model.architecture.interfaces.PermissionInterface;
import com.kailin.architecture_model.architecture.interfaces.ReceiverInterface;
import com.kailin.architecture_model.util.CheckVersionUtil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public abstract class ArchitectureFragment<B extends ViewDataBinding, VM extends ArchitectureViewModel>
        extends Fragment implements OnRequestPermissionsResult, PermissionInterface, ReceiverInterface, ArchitectureInterface<VM> {

    protected B binding;
    protected VM viewModel;
    protected Context context;
    protected FragmentInterface fragmentInterface;
    protected ReceiverInterface receiverInterface;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Class<VM> clazz = getViewModelClass();
        if (clazz != null){
            viewModel = ViewModelProviders.of(this).get(getViewModelClass());
            getLifecycle().addObserver(viewModel);
        }
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
        if (context instanceof ReceiverInterface) {
            receiverInterface = (ReceiverInterface) context;
        }
        initBindings();
    }

    @Override
    public void checkPermission(int requestCode, String... permissions) {
        if(CheckVersionUtil.getInstance().isBelowM())
            return;
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permissions, 0);
                return;
            }
        }
        onPermissionGranted(requestCode, permissions, new int[]{});
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int grantResult : grantResults) {
            if (grantResult == PackageManager.PERMISSION_DENIED) {
                onPermissionDenied(requestCode, permissions, grantResults);
                return;
            }
        }
        onPermissionGranted(requestCode, permissions, grantResults);
    }

    @Override
    public void onPermissionGranted(int requestCode, String[] permissions, int[] grantResults) {
    }

    @Override
    public void onPermissionDenied(int requestCode, String[] permissions, int[] grantResults) {
    }

    @Override
    public void registerReceiver(BroadcastReceiver receiver, String... actions) {
        receiverInterface.registerReceiver(receiver, actions);
    }

    @Override
    public void unRegisterReceiver(BroadcastReceiver receiver) {
        receiverInterface.unRegisterReceiver(receiver);
    }
}
