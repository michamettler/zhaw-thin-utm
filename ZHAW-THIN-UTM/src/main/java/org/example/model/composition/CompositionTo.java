package org.example.model.composition;

import org.example.model.State;

public class CompositionTo extends Composition {

    private Direction direction;
    public CompositionTo(State state, int bandValue, Direction direction) {
        super(state, bandValue);
        this.direction = direction;
    }

    public int getWriteValue() {
        return getBandValue();
    }

    public Direction getDirection() {
        return direction;
    }
}
