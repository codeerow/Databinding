package com.codeerow.databinding.androidx.core.bindings.textview;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.codeerow.databinding.Binding;

import java.lang.ref.WeakReference;


public class TextBinding extends Binding {

    private WeakReference<TextView> viewRef;

    private MutableLiveData<String> value;
    private LifecycleOwner lifecycleOwner;

    private boolean twoWay;


    public TextBinding(TextView view, LifecycleOwner lifecycleOwner, MutableLiveData<String> value) {
        this.viewRef = new WeakReference<>(view);
        this.twoWay = false;
        this.value = value;
        this.lifecycleOwner = lifecycleOwner;
    }

    public TextBinding(TextView view, LifecycleOwner lifecycleOwner, MutableLiveData<String> value, boolean twoWay) {
        this.viewRef = new WeakReference<>(view);
        this.value = value;
        this.twoWay = twoWay;
        this.lifecycleOwner = lifecycleOwner;
    }


    @Override
    public void execute() {
        value.observe(lifecycleOwner, new Observer<String>() {
            TextView view = viewRef.get();

            @Override
            public void onChanged(String currentValue) {
                String previousValue = view.getText().toString();
                if (previousValue.equals(currentValue)) return;
                view.setText(currentValue);

                if (twoWay) {
                    view.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override
                        public void afterTextChanged(Editable text) {
                            value.setValue(text == null ? "" : text.toString());
                        }
                    });
                }
            }
        });
    }
}
