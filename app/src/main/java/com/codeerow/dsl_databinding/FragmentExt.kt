package com.codeerow.dsl_databinding

import androidx.fragment.app.Fragment


fun Fragment.databinding(form: DataBinding.() -> Unit) {
    val dataBinding = DataBinding(this)
    form(dataBinding)
}
