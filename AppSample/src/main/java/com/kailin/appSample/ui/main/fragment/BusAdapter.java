package com.kailin.appSample.ui.main.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kailin.appSample.MyApplication;
import com.kailin.appSample.data.bus.route.BusRoute;
import com.kailin.appSample.databinding.MainBusItemBinding;
import com.kailin.appSample.util.MyDiffUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public final class BusAdapter extends RecyclerView.Adapter<BusAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater = LayoutInflater.from(MyApplication.getInstance());
    private final List<BusRoute> busRoutes = new ArrayList<>();

    @NonNull
    @Override
    public BusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(MainBusItemBinding.inflate(layoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BusAdapter.ViewHolder holder, int position) {
        holder.bind(busRoutes.get(position));
    }

    @Override
    public int getItemCount() {
        return busRoutes.size();
    }

    public void setData(List<BusRoute> newBusRoute) {
        MyDiffUtil myDiffUtil = MyDiffUtil.getInstance();
        myDiffUtil.setDiff(this, busRoutes, newBusRoute);
        busRoutes.clear();
        busRoutes.addAll(newBusRoute);
        notifyDataSetChanged();
    }

    protected static final class ViewHolder extends RecyclerView.ViewHolder {

        protected final MainBusItemBinding mainBusItemBinding;

        public ViewHolder(@NonNull MainBusItemBinding binding) {
            super(binding.getRoot());
            this.mainBusItemBinding = binding;
        }

        public void bind(BusRoute busRoute) {
            mainBusItemBinding.setBusRoute(busRoute);
            mainBusItemBinding.executePendingBindings();
        }
    }
}
