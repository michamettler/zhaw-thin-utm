package org.example;

import java.util.ArrayList;
import java.util.List;

public class MultiplicationHelper {
    public String parseMultiplication(int factor1, int factor2) {
        return "111" + "1".repeat(Math.max(0, factor1)) + "0" + "1".repeat(Math.max(0, factor2));
    }

    public int parseResult(List<String> band) {
        StringBuilder b = new StringBuilder();
        band.forEach(b::append);
        List<String> splitString = new ArrayList<>(List.of(b.toString().split("0")));

        int resultCounter = 0;
        for (int i = 0; i < splitString.get(splitString.size() - 1).length(); i++) {
            resultCounter++;
        }
        return resultCounter;
    }
}
