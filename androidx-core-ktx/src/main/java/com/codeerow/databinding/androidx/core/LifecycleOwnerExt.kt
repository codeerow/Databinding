package com.codeerow.databinding.androidx.core

import androidx.lifecycle.LifecycleOwner


fun LifecycleOwner.dataBinding(form: LifecycleDataBinding.() -> Unit): LifecycleDataBinding {
    val dataBinding = LifecycleDataBinding(this)
    form(dataBinding)
    return dataBinding
}