package com.kailin.sample.main;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.a116301.myapplication.R;
import com.example.a116301.myapplication.databinding.MainActivityBinding;
import com.google.android.material.snackbar.Snackbar;
import com.kailin.sample.base.BaseActivity;

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
