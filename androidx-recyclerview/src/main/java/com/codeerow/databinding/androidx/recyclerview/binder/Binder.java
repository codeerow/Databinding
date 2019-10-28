package com.codeerow.databinding.androidx.recyclerview.binder;

import android.view.View;

public interface Binder<T> {
    void bind(T item, View itemView, int position);
}
