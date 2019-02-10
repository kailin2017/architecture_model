package com.kailin.architecture_model.architecture;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.kailin.architecture_model.architecture.interfaces.ArchitectureInterface;
import com.kailin.architecture_model.architecture.interfaces.OnRequestPermissionsResult;
import com.kailin.architecture_model.architecture.interfaces.PermissionInterface;
import com.kailin.architecture_model.architecture.interfaces.ReceiverInterface;
import com.kailin.architecture_model.receiver.ShutdownReceiver;
import com.kailin.architecture_model.util.CheckVersionUtil;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public abstract class ArchitectureActivity<B extends ViewDataBinding, VM extends ArchitectureViewModel>
        extends AppCompatActivity implements OnRequestPermissionsResult, PermissionInterface, ReceiverInterface, ArchitectureInterface<VM> {

    protected B binding;
    protected VM viewModel;
    protected Context context;
    private final ArrayList<BroadcastReceiver> broadcastReceivers = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Class<VM> clazz = getViewModelClass();
        if (clazz != null){
            viewModel = ViewModelProviders.of(this).get(getViewModelClass());
            getLifecycle().addObserver(viewModel);
        }
        binding = DataBindingUtil.setContentView(this, getLayoutRes());
        binding.setLifecycleOwner(this);
        context = this;
        registerReceiver(new ShutdownReceiver(), ShutdownReceiver.ACTION_SHUTOWN);
        initBindings();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (BroadcastReceiver broadcastReceiver : broadcastReceivers) {
            unRegisterReceiver(broadcastReceiver);
        }
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
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
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
        IntentFilter intentFilter = new IntentFilter();
        for (String action : actions) {
            intentFilter.addAction(action);
        }
        registerReceiver(receiver, intentFilter);
        broadcastReceivers.add(receiver);
    }

    @Override
    public void unRegisterReceiver(BroadcastReceiver receiver) {
        super.unregisterReceiver(receiver);
        broadcastReceivers.remove(receiver);
    }
}
