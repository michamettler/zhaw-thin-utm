package org.example;

import org.example.util.Mode;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TuringMachineParser tm = new TuringMachineParser("010010001010011000101010010110001001001010011000100010001010", Mode.RUN);
        tm.parse();
        tm.run();
    }
}