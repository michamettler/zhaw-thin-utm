package org.example.util;

public enum SymbolMapping {
    ZERO("0"),
    ONE("00"),
    EMPTY("000");

    public final String value;

    SymbolMapping(String value) {
        this.value = value;
    }

    public static SymbolMapping findEnum(String symbol) {
        for (SymbolMapping v : values()) {
            if (v.value.equals(symbol)) {
                return v;
            }
        }
        return null;
    }

}
