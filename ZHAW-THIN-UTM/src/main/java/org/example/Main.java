package org.example;

import org.example.util.Mode;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TuringMachineParser tm = new TuringMachineParser("10100101001001101010001010011000100101001001100010100101001111010", Mode.STEP);
        tm.parse();
        tm.run();
    }
}