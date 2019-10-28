package com.codeerow.databinding.androidx.recyclerview.bindings

import android.view.View
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.codeerow.databinding.DataBinding
import com.codeerow.databinding.androidx.core.LifecycleDataBinding
import com.codeerow.databinding.androidx.recyclerview.binder.Binder


fun <T> DataBinding.items(
    view: RecyclerView,
    layout: Int,
    items: List<T>,
    bind: (item: T, itemView: View, position: Int) -> Unit
) {
    this.apply(ItemsBinding<T>(view, layout, items, Binder(bind)))
}


fun <T> LifecycleDataBinding.items(
    view: RecyclerView,
    layout: Int,
    items: LiveData<List<T>>,
    bind: (item: T, itemView: View, position: Int) -> Unit
) {
    this.apply(LiveDataItemsBinding<T>(view, this.lifecycleOwner, layout, items, Binder(bind)))
}





