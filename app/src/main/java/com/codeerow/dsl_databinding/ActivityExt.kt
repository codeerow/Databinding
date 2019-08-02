package com.codeerow.dsl_databinding

import androidx.core.app.ComponentActivity


fun ComponentActivity.databinding(form: DataBinding.() -> Unit) {
    val dataBinding = DataBinding(this)
    form(dataBinding)
}