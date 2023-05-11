package org.example.model.composition;

import org.example.model.State;
import org.example.util.Alphabet;

public abstract class Composition {

    private final State state;

    private final Alphabet bandValue;

    public Composition(State state, Alphabet bandValue) {
        this.state = state;
        this.bandValue = bandValue;
    }

    public State getState() {
        return state;
    }

    public Alphabet getBandValue() {
        return bandValue;
    }
}
