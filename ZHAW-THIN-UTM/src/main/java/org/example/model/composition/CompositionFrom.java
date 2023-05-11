package org.example.model.composition;

import org.example.model.State;
import org.example.util.Alphabet;

public class CompositionFrom extends Composition {

    public CompositionFrom(State state, Alphabet bandValue) {
        super(state, bandValue);
    }

    public Alphabet getReadValue() {
        return getBandValue();
    }

    @Override
    public String toString() {
        return "δ(" + getState().toString() + "," + getReadValue().value + ")";
    }
}
