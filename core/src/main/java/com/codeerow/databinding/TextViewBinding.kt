package com.codeerow.databinding

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer


fun DataBinding.text(view: TextView, liveData: MutableLiveData<String>, twoWay: Boolean = false) {
    liveData.observe(this.lifecycleOwner, Observer { currentValue ->
        val previousValue = view.text.toString()
        if (previousValue == currentValue) return@Observer
        view.text = currentValue
    })

    if (twoWay) {
        view.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(text: Editable?) {
                liveData.value = text?.toString() ?: ""
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}
