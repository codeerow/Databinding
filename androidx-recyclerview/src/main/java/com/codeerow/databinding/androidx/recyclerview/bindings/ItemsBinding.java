package com.codeerow.databinding.androidx.recyclerview.bindings;

import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;

import com.codeerow.databinding.Binding;
import com.codeerow.databinding.androidx.recyclerview.adapters.ListAdapter;
import com.codeerow.databinding.androidx.recyclerview.binder.Binder;

import java.lang.ref.WeakReference;
import java.util.List;


public class ItemsBinding<T> extends Binding {

    private WeakReference<RecyclerView> viewRef;

    private List<T> items;

    private Binder<T> binder;
    @LayoutRes
    private int layoutRes;


    public ItemsBinding(RecyclerView view, @LayoutRes int layoutRes, List<T> items, Binder<T> binder) {
        this.viewRef = new WeakReference<>(view);
        this.layoutRes = layoutRes;
        this.items = items;
        this.binder = binder;
    }


    @Override
    public void execute() {
        RecyclerView view = viewRef.get();
        view.setAdapter(new ListAdapter<>(items, layoutRes, binder));
    }
}
