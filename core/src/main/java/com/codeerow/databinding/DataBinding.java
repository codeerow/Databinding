package com.codeerow.databinding;


abstract public class DataBinding {

    final public void apply(Binding... bindings) {
        for (Binding binding : bindings) {
            binding.execute();
        }
    }
}
