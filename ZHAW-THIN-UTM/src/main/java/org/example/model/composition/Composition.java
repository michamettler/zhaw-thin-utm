package org.example.model.composition;

import org.example.model.State;

public abstract class Composition {

    private State state;

    private int bandValue;

    public Composition(State state, int bandValue) {
        this.state = state;
        this.bandValue = bandValue;
    }

    public State getState() {
        return state;
    }

    public int getBandValue() {
        return bandValue;
    }
}
