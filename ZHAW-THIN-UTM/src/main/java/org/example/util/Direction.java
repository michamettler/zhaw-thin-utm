package org.example.util;

public enum Direction {
    L("0"),
    R("00");

    public final String value;

    Direction(String value) {
        this.value = value;
    }

    public static Direction findEnum(String symbol) {
        for (Direction v : values()) {
            if (v.value.equals(symbol)) {
                return v;
            }
        }
        return null;
    }
}
