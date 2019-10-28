package com.codeerow.databinding.androidx.core.bindings.toolbar;

import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.codeerow.databinding.Binding;

import java.lang.ref.WeakReference;


public class NavButtonClickBinding extends Binding {

    private WeakReference<Toolbar> viewRef;
    private View.OnClickListener listener;


    public NavButtonClickBinding(Toolbar view, View.OnClickListener listener) {
        this.viewRef = new WeakReference<>(view);
        this.listener = listener;
    }

    @Override
    public void execute() {
        Toolbar view = viewRef.get();
        view.setOnClickListener(listener);
    }
}
