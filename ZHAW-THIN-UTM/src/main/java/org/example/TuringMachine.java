package org.example;

import org.example.model.State;
import org.example.util.Alphabet;
import org.example.util.Direction;

import java.util.ArrayList;
import java.util.List;

public class TuringMachine {

    private int goedelNumber;
    private State currentState;
    private int calculationIndex = 0;
    private List<String> band;
    private int headPosition = 15;

    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";

    public TuringMachine(int goedelNumber) {
        this.goedelNumber = goedelNumber;
        band = new ArrayList<>();
        initializeTape();
    }

    public TuringMachine() {
        band = new ArrayList<>();
        initializeTape();
    }

    public void initializeTape() {
        for (int i = 0; i < 29; i++) {
            band.add(Alphabet.EMPTY.value);
        }
    }

    public String readSymbol() {
        return band.get(headPosition);
    }

    public void writeSymbol(Direction direction, Alphabet symbol) {
        band.set(headPosition, symbol.value);
        if (direction == Direction.L) {
            headPosition--;
        } else if (direction == Direction.R) {
            headPosition++;
        }
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getCalculationIndex() {
        return calculationIndex;
    }

    public int getGoedelNumber() {
        return goedelNumber;
    }

    public void print() {
        System.out.println("Current State: " + currentState.toString());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 29; i++) {
            if (i == headPosition) {
                stringBuilder.append(ANSI_GREEN + "| ").append(band.get(i)).append(" |" + ANSI_RESET);
            } else {
                stringBuilder.append("| ").append(band.get(i)).append(" |");
            }
        }
        System.out.println("Band:");
        System.out.println(stringBuilder);
        System.out.println("Amount of calculations: " + calculationIndex);
        System.out.println("--------------------------------------------\n\n");
    }
}
