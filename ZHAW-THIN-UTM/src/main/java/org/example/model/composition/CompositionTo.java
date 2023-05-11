package org.example.model.composition;

import org.example.model.State;
import org.example.util.Alphabet;
import org.example.util.Direction;

public class CompositionTo extends Composition {

    private final Direction direction;

    public CompositionTo(State state, Alphabet bandValue, Direction direction) {
        super(state, bandValue);
        this.direction = direction;
    }

    public Alphabet getWriteValue() {
        return getBandValue();
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "δ(" + getState().toString() + "," + getWriteValue().value + "," + direction + ")";
    }
}
