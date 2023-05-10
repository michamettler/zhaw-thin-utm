package org.example.model.composition;

import org.example.model.State;

public class CompositionFrom extends Composition {

    public CompositionFrom(State state, int bandValue) {
        super(state, bandValue);
    }

    public int getReadValue() {
        return getBandValue();
    }

}
