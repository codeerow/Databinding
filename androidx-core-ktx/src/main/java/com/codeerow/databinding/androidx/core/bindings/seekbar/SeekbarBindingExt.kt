package com.codeerow.databinding.androidx.core.bindings.seekbar

import android.widget.SeekBar
import androidx.lifecycle.MutableLiveData
import com.codeerow.databinding.androidx.core.LifecycleDataBinding


fun LifecycleDataBinding.progress(
    view: SeekBar,
    liveData: MutableLiveData<Int>,
    twoWay: Boolean = false
) {
    this.apply(ProgressBinding(view, lifecycleOwner, liveData, twoWay))
}
