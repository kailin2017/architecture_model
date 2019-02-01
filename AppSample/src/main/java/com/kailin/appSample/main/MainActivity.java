package com.kailin.appSample.main;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.kailin.appSample.R;
import com.kailin.appSample.base.BaseActivity;
import com.kailin.appSample.databinding.MainActivityBinding;

import androidx.lifecycle.ViewModel;

public class MainActivity extends BaseActivity<MainActivityBinding, ViewModel> implements View.OnClickListener {

    @Override
    public int getLayoutRes() {
        return R.layout.main_activity;
    }

    @Override
    public Class<ViewModel> getViewModelClass() {
        return null;
    }

    @Override
    public void initBindings() {
        binding.setOnClickListener(this::onClick);
        setSupportActionBar(binding.toolbar);
        replaceFragment(MainFragment.getInstance());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
}
