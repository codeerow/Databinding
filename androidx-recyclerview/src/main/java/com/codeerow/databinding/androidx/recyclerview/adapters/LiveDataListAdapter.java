package com.codeerow.databinding.androidx.recyclerview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.codeerow.databinding.androidx.recyclerview.binder.Binder;

import java.util.List;


public class LiveDataListAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LiveData<List<T>> list;
    @LayoutRes
    private int layoutRes;
    private Binder<T> binder;


    public LiveDataListAdapter(LiveData<List<T>> list, @LayoutRes int layoutRes, Binder<T> binder) {
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
        List<T> listValue = list.getValue();
        if (listValue != null) {
            T item = listValue.get(position);
            binder.bind(item, holder.itemView, position);
        }
    }

    @Override
    public int getItemCount() {
        List<T> listValue = list.getValue();
        return listValue == null ? 0 : listValue.size();
    }
}
