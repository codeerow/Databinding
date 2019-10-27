package com.codeerow.databinding

import android.view.View
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer


fun DataBinding.visibility(
    view: View,
    liveData: MutableLiveData<Boolean>,
    goneWhenInvisible: Boolean = false
) {
    liveData.observe(this.lifecycleOwner, Observer { visible ->
        view.visibility = if (visible) {
            View.VISIBLE
        } else {
            if (goneWhenInvisible) View.GONE
            else View.INVISIBLE
        }
    })
}

fun DataBinding.enabled(view: View, liveData: MutableLiveData<Boolean>) {
    liveData.observe(this.lifecycleOwner, Observer { isEnabled ->
        view.isEnabled = isEnabled
    })
}


fun DataBinding.click(view: View, listener: View.OnClickListener) {
    view.setOnClickListener(listener)
}

fun DataBinding.click(view: View, listener: (View) -> Unit) {
    view.setOnClickListener(listener)
}