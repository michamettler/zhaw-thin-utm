package org.example.util;

public enum Alphabet {
    ZERO("0"),
    ONE("1"),
    EMPTY("_");

    public final String value;

    Alphabet(String value) {
        this.value = value;
    }
}
