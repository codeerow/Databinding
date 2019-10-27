package com.codeerow.databinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView


fun <T> DataBinding.items(
    view: RecyclerView,
    layout: Int,
    items: List<T>,
    bind: (item: T, itemView: View, position: Int) -> Unit
) {
    view.adapter = ListAdapter(items, layout, bind)
}


fun <T> DataBinding.items(
    view: RecyclerView,
    layout: Int,
    items: LiveData<List<T>>,
    bind: (item: T, itemView: View, position: Int) -> Unit
) {
    view.adapter = LiveDataListAdapter(items, layout, bind)
    items.observe(this.lifecycleOwner, Observer {
        view.adapter?.notifyDataSetChanged()
    })
}


class LiveDataListAdapter<T>(
    private val list: LiveData<List<T>>,
    val layout: Int,
    val bind: (item: T, itemView: View, position: Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = list.value?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(layout, parent, false)
        return object : RecyclerView.ViewHolder(view) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list.value?.get(position)
        item?.let { bind(it, holder.itemView, position) }
    }
}

class ListAdapter<T>(
    private val list: List<T>,
    val layout: Int,
    val bind: (item: T, itemView: View, position: Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(layout, parent, false)
        return object : RecyclerView.ViewHolder(view) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        item?.let { bind(it, holder.itemView, position) }
    }
}


