package com.codeerow.databinding.androidx.core.bindings.view

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.codeerow.databinding.androidx.core.LifecycleDataBinding


fun LifecycleDataBinding.visibility(
    view: View,
    liveData: MutableLiveData<Boolean>,
    goneWhenInvisible: Boolean = false
) {
    this.apply(VisibilityBinding(view, lifecycleOwner, liveData, goneWhenInvisible))
}

fun LifecycleDataBinding.enabled(view: View, liveData: MutableLiveData<Boolean>) {
    this.apply(EnabledBinding(view, lifecycleOwner, liveData))
}


fun LifecycleDataBinding.click(view: View, listener: View.OnClickListener) {
    this.apply(ClickBinding(view, listener))
}

fun LifecycleDataBinding.click(view: View, listener: (View) -> Unit) {
    this.apply(ClickBinding(view, listener))
}