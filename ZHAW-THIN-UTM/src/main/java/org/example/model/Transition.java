package org.example.model;

import org.example.model.composition.CompositionFrom;
import org.example.model.composition.CompositionTo;

public class Transition {

    private CompositionFrom compositionFrom;
    private CompositionTo compositionTo;

    public Transition(CompositionFrom compositionFrom, CompositionTo compositionTo) {
        this.compositionFrom = compositionFrom;
        this.compositionTo = compositionTo;
    }

    public CompositionFrom getCompositionFrom() {
        return compositionFrom;
    }

    public CompositionTo getCompositionTo() {
        return compositionTo;
    }

    @Override
    public String toString() {
        return compositionFrom + " = " + compositionTo;
    }
}
