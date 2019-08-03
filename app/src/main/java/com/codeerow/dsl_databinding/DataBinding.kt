package com.codeerow.dsl_databinding

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer


class DataBinding(private val lifecycleOwner: LifecycleOwner) {

    fun TextView.text(liveData: MutableLiveData<String>, twoWay: Boolean = false) {
        liveData.observe(lifecycleOwner, Observer {
            val previousValue = this.text.toString()
            val currentValue = liveData.value ?: ""
            if (previousValue == currentValue) return@Observer
            this.text = currentValue
        })

        if (twoWay) {
            this.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(text: Editable?) {
                    liveData.value = text?.toString() ?: ""
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })
        }
    }

    fun View.visibility(liveData: MutableLiveData<Boolean>, goneWhenInvisible: Boolean = false) {
        liveData.observe(lifecycleOwner, Observer { visible ->
            visibility = if (visible) {
                View.VISIBLE
            } else {
                if (goneWhenInvisible) View.GONE
                else View.INVISIBLE
            }
        })
    }
}