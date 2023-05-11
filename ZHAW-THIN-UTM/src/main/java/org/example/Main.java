package org.example;

public class Main {
    public static void main(String[] args) {
        TuringMachine tm = new TuringMachine("0100100010100");
        tm.run();
    }
}