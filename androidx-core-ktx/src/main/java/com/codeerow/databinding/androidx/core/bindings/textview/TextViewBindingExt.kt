package com.codeerow.databinding.androidx.core.bindings.textview

import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.codeerow.databinding.androidx.core.LifecycleDataBinding


fun LifecycleDataBinding.text(
    view: TextView,
    liveData: MutableLiveData<String>,
    twoWay: Boolean = false
) {
    this.apply(TextBinding(view, lifecycleOwner, liveData, twoWay))
}
