package com.kailin.appSample.util;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public final class MyDiffUtil {

    private static final AtomicReference<MyDiffUtil> reference = new AtomicReference<>();

    public static MyDiffUtil getInstance() {
        while (true) {
            MyDiffUtil instance = reference.get();
            if (instance != null)
                return instance;

            instance = new MyDiffUtil();
            if (reference.compareAndSet(null, instance))
                return instance;
        }
    }

    public <T> void setDiff(RecyclerView.Adapter adapter, List<T> oldData, List<T> newData) {
        setDiff(adapter, new MyDiffCallBack<>(oldData, newData));
    }

    public <T> void setDiff(RecyclerView.Adapter adapter, MyDiffCallBack<T> callBack) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(callBack, true);
        diffResult.dispatchUpdatesTo(adapter);
    }

    public static class MyDiffCallBack<T> extends DiffUtil.Callback {

        private final List<T> oldData, newData;

        private MyDiffCallBack(List<T> oldData, List<T> newData) {
            this.oldData = oldData;
            this.newData = newData;
        }

        @Override
        public int getOldListSize() {
            return oldData.size();
        }

        @Override
        public int getNewListSize() {
            return newData.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            T oldT = oldData.get(oldItemPosition);
            T newT = newData.get(newItemPosition);
            return oldT.equals(newT);
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return areItemsTheSame(oldItemPosition, newItemPosition);
        }
    }
}
