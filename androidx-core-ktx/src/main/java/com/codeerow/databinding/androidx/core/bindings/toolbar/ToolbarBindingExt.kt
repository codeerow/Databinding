package com.codeerow.databinding.android.core.bindings.toolbar

import android.view.View
import androidx.appcompat.widget.Toolbar
import com.codeerow.databinding.DataBinding


fun DataBinding.navButtonClick(view: Toolbar, listener: View.OnClickListener) {
    view.setNavigationOnClickListener(listener)
}

fun DataBinding.navButtonClick(view: Toolbar, listener: (View) -> Unit) {
    view.setNavigationOnClickListener(listener)
}