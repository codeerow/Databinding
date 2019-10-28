package com.codeerow.databinding.androidx.core.bindings.view;


import android.view.View;

import com.codeerow.databinding.Binding;

import java.lang.ref.WeakReference;

public class ClickBinding extends Binding {

    private WeakReference<View> viewRef;
    private View.OnClickListener listener;


    public ClickBinding(View view, View.OnClickListener listener) {
        this.viewRef = new WeakReference<>(view);
        this.listener = listener;
    }

    @Override
    public void execute() {
        View view = viewRef.get();
        view.setOnClickListener(listener);
    }
}
