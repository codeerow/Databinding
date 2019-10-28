package com.codeerow.databinding.androidx.recyclerview.bindings;


import androidx.annotation.LayoutRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.codeerow.databinding.Binding;
import com.codeerow.databinding.androidx.recyclerview.adapters.LiveDataListAdapter;
import com.codeerow.databinding.androidx.recyclerview.binder.Binder;

import java.lang.ref.WeakReference;
import java.util.List;


public class LiveDataItemsBinding<T> extends Binding {

    private WeakReference<RecyclerView> viewRef;

    private LiveData<List<T>> items;
    private LifecycleOwner lifecycleOwner;

    private Binder<T> binder;
    @LayoutRes
    private int layoutRes;


    public LiveDataItemsBinding(RecyclerView view, LifecycleOwner lifecycleOwner, @LayoutRes int layoutRes, LiveData<List<T>> items, Binder<T> binder) {
        this.viewRef = new WeakReference<>(view);
        this.lifecycleOwner = lifecycleOwner;
        this.layoutRes = layoutRes;
        this.items = items;
        this.binder = binder;
    }


    @Override
    public void execute() {
        RecyclerView view = viewRef.get();
        view.setAdapter(new LiveDataListAdapter<>(items, layoutRes, binder));
        items.observe(this.lifecycleOwner, new Observer<List<T>>() {
            RecyclerView view = viewRef.get();

            @Override
            public void onChanged(List<T> list) {
                RecyclerView.Adapter adapter = view.getAdapter();
                if (adapter != null) adapter.notifyDataSetChanged();
            }
        });
    }
}
