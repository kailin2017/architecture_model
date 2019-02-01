package com.kailin.architecture_model.architecture;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.kailin.architecture_model.architecture.interfaces.ArchitectureInterface;
import com.kailin.architecture_model.architecture.interfaces.FragmentInterface;
import com.kailin.architecture_model.architecture.interfaces.OnRequestPermissionsResult;
import com.kailin.architecture_model.architecture.interfaces.PermissionInterface;
import com.kailin.architecture_model.architecture.interfaces.ReceiverInterface;
import com.kailin.architecture_model.receiver.ShutdownReceiver;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public abstract class ArchitectureActivity<B extends ViewDataBinding, VM extends ViewModel>
        extends AppCompatActivity implements OnRequestPermissionsResult, PermissionInterface, ReceiverInterface, ArchitectureInterface<VM>, FragmentInterface {

    protected B binding;
    protected VM viewModel;
    protected Context context;
    protected OnRequestPermissionsResult onRequestPermissionsResult;
    private final ArrayList<BroadcastReceiver> broadcastReceivers = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Class<VM> clazz = getViewModelClass();
        if (clazz != null)
            viewModel = ViewModelProviders.of(this).get(getViewModelClass());
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

    public void checkPermission(OnRequestPermissionsResult permissionListener, int requestCode, String... permissions) {
        onRequestPermissionsResult = permissionListener;
        for (String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(this, permissions, 0);
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
        if (onRequestPermissionsResult != null)
            onRequestPermissionsResult.onPermissionGranted(requestCode, permissions, grantResults);
    }

    @Override
    public void onPermissionDenied(int requestCode, String[] permissions, int[] grantResults) {
        if (onRequestPermissionsResult != null)
            onRequestPermissionsResult.onPermissionDenied(requestCode, permissions, grantResults);
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

    @Override
    public void replaceFragment(Fragment fragment) {
        replaceFragment(fragment, null);
    }

    @Override
    public void replaceFragment(Fragment fragment, String TAG) {
        replaceFragment(getContainerViewId(), fragment, TAG);
    }

    @Override
    public void replaceFragment(int layoutId, Fragment fragment, String TAG) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(layoutId, fragment, TAG)
                .commitAllowingStateLoss();
    }

    @Override
    public void addFragment(Fragment fragment) {
        addFragment(fragment, null);
    }

    @Override
    public void addFragment(Fragment fragment, String TAG) {
        addFragment(getContainerViewId(), fragment, TAG);
    }

    @Override
    public void addFragment(int layoutId, Fragment fragment, String TAG) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(layoutId, fragment, TAG)
                .commitAllowingStateLoss();
    }

    @Override
    public void popFragment() {
        getSupportFragmentManager().popBackStack();
    }

}
