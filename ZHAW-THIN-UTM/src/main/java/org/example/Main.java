package org.example;

public class Main {
    public static void main(String[] args) {
        TuringMachine tm = new TuringMachine("010010001010011000101010010110001001001010011000100010001010");
        tm.run();
    }
}