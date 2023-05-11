package org.example.model;

public class State {

    private final int stateNumber;

    private final boolean accepting;

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

    @Override
    public String toString() {
        return "q" + stateNumber;
    }
}
