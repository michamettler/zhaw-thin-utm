package org.example;

public class Main {
    public static void main(String[] args) {
        TuringMachineParser tm = new TuringMachineParser("1010010100100110101000101001100010010100100110001010010100");
        tm.run();
    }
}