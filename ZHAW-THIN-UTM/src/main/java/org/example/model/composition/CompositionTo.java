package org.example.model.composition;

import org.example.util.Direction;
import org.example.model.State;
import org.example.util.SymbolMapping;

public class CompositionTo extends Composition {

    private Direction direction;

    public CompositionTo(State state, SymbolMapping bandValue, Direction direction) {
        super(state, bandValue);
        this.direction = direction;
    }

    public SymbolMapping getWriteValue() {
        return getBandValue();
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "δ(" + getState().toString() + "," + getWriteValue() + "," + direction + ")";
    }
}
