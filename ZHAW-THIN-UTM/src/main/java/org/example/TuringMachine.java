package org.example;

import org.example.util.Alphabet;

import java.util.LinkedList;

public class TuringMachine {

    private int goedelNumber;

    public TuringMachine(int goedelNumber) {
        this.goedelNumber = goedelNumber;
    }

    public TuringMachine() {
    }

    private LinkedList<Alphabet> band = new LinkedList<>();


}
