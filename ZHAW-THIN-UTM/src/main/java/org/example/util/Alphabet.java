package org.example.util;

public enum Alphabet {
    ZERO("0"),
    ONE("1"),
    EMPTY("_");

    public final String value;

    Alphabet(String value) {
        this.value = value;
    }

    public static Alphabet findEnum(String symbol) {
        for (Alphabet v : values()) {
            if (v.value.equals(symbol)) {
                return v;
            }
        }
        return null;
    }
}
