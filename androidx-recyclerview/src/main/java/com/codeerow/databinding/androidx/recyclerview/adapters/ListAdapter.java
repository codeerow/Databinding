package com.codeerow.databinding.androidx.recyclerview.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codeerow.databinding.androidx.recyclerview.binder.Binder;

import java.util.List;


public class ListAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<T> list;
    @LayoutRes
    private int layoutRes;
    private Binder<T> binder;


    public ListAdapter(List<T> list, @LayoutRes int layoutRes, Binder<T> binder) {
        this.list = list;
        this.layoutRes = layoutRes;
        this.binder = binder;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(layoutRes, parent, false);
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        T item = list.get(position);
        binder.bind(item, holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

