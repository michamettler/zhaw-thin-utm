package org.example.model.composition;

import org.example.model.State;
import org.example.util.Alphabet;
import org.example.util.SymbolMapping;

public class CompositionFrom extends Composition {

    public CompositionFrom(State state, SymbolMapping bandValue) {
        super(state, bandValue);
    }

    public SymbolMapping getReadValue() {
        return getBandValue();
    }

    @Override
    public String toString() {
        return "δ(" + getState().toString() + "," + getReadValue() + ")";
    }
}
