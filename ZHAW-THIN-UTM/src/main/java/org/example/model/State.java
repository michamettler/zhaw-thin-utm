package org.example.model;

public class State {

    private final int stateNumber;

    public State(int stateNumber) {
        this.stateNumber = stateNumber;
    }

    public int getStateNumber() {
        return stateNumber;
    }

    @Override
    public String toString() {
        return "q" + stateNumber;
    }
}
