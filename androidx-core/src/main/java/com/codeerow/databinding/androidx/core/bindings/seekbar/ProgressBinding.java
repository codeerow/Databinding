package com.codeerow.databinding.androidx.core.bindings.seekbar;

import android.widget.SeekBar;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.codeerow.databinding.Binding;

import java.lang.ref.WeakReference;


public class ProgressBinding extends Binding {

    private WeakReference<SeekBar> viewRef;

    private MutableLiveData<Integer> value;
    private LifecycleOwner lifecycleOwner;

    private boolean twoWay;


    public ProgressBinding(SeekBar view, LifecycleOwner lifecycleOwner, MutableLiveData<Integer> value) {
        this.viewRef = new WeakReference<>(view);
        this.twoWay = false;
        this.value = value;
        this.lifecycleOwner = lifecycleOwner;
    }

    public ProgressBinding(SeekBar view, LifecycleOwner lifecycleOwner, MutableLiveData<Integer> value, boolean twoWay) {
        this.viewRef = new WeakReference<>(view);
        this.value = value;
        this.twoWay = twoWay;
        this.lifecycleOwner = lifecycleOwner;
    }


    @Override
    public void execute() {
        value.observe(this.lifecycleOwner, new Observer<Integer>() {
            SeekBar view = viewRef.get();

            @Override
            public void onChanged(Integer currentValue) {
                Integer previousValue = view.getProgress();
                if (previousValue.equals(currentValue)) return;
                else view.setProgress(currentValue);

                if (twoWay) {
                    view.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                            value.setValue(progress);
                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar) {

                        }

                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar) {

                        }
                    });
                }
            }
        });
    }
}
