package org.example;

import org.example.util.Mode;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TuringMachineParser tm = new TuringMachineParser("1010010100100110101000101001100010010100100110001010010100", Mode.STEP);
        tm.parse();
        tm.run();
    }
}