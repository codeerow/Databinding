package com.codeerow.databinding

import android.widget.SeekBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.codeerow.databinding.DataBinding


fun DataBinding.progress(view: SeekBar, liveData: MutableLiveData<Int>, twoWay: Boolean = false) {
    liveData.observe(this.lifecycleOwner, Observer { currentValue ->
        val previousValue = view.progress
        if (previousValue == currentValue) return@Observer
        view.progress = currentValue
    })
    if (twoWay) {
        view.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                liveData.value = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }
}
