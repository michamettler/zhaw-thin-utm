package org.example.model.composition;

import org.example.model.State;
import org.example.util.Alphabet;
import org.example.util.SymbolMapping;

public abstract class Composition {

    private State state;

    private SymbolMapping bandValue;

    public Composition(State state, SymbolMapping bandValue) {
        this.state = state;
        this.bandValue = bandValue;
    }

    public State getState() {
        return state;
    }

    public SymbolMapping getBandValue() {
        return bandValue;
    }
}
