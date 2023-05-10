package org.example.model;

import java.util.Optional;

public class State {

    private int stateNumber;

    private boolean accepting;

    public State(int stateNumber, boolean accepting) {
        this.stateNumber = stateNumber;
        this.accepting = accepting;
    }

    public int getStateNumber() {
        return stateNumber;
    }

    public boolean isAccepting() {
        return accepting;
    }
}
