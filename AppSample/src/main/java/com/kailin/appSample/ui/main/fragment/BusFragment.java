package com.kailin.appSample.ui.main.fragment;

import android.view.Menu;
import android.view.MenuInflater;

import com.kailin.appSample.R;
import com.kailin.appSample.data.bus.route.BusRoute;
import com.kailin.appSample.databinding.MainBusFragmentBinding;
import com.kailin.architecture_model.architecture.ArchitectureFragment;

import java.util.List;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public final class BusFragment extends ArchitectureFragment<MainBusFragmentBinding, BusViewModel> implements SearchView.OnQueryTextListener {

    protected SearchView searchView;
    protected BusAdapter busAdapter = new BusAdapter();

    @Override
    public int getLayoutRes() {
        return R.layout.main_bus_fragment;
    }

    @Override
    public Class getViewModelClass() {
        return BusViewModel.class;
    }

    @Override
    public void initBindings() {
        setSupportActionBar(binding.toolbar);
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(busAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.search, menu);
        searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextListener(this);
        viewModel.busRoutesObserver(this, this::busRoutesOnChanged);
    }

    public void busRoutesOnChanged(List<BusRoute> busRoutes) {
        busAdapter.setData(busRoutes);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.queryBus(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        viewModel.queryBus(newText);
        return true;
    }
}
