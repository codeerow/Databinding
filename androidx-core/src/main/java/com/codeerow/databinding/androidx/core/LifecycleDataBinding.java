package com.codeerow.databinding.androidx.core;

import androidx.lifecycle.LifecycleOwner;

import com.codeerow.databinding.DataBinding;


public class LifecycleDataBinding extends DataBinding {

    public LifecycleOwner lifecycleOwner = null;


    public LifecycleDataBinding() {
    }

    public LifecycleDataBinding(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }
}
