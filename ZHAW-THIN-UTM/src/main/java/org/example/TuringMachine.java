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
    private static final String ANSI_GREY = "\u001B[37m";
    private static final String ANSI_RESET = "\u001B[0m";

    public TuringMachine(int goedelNumber) {
        this.goedelNumber = goedelNumber;
        band = new ArrayList<>();
    }

    public TuringMachine() {
        band = new ArrayList<>();
    }

    public void initializeTape(String calculationValues) {
        for (int i = 0; i < 15; i++) {
            band.add(Alphabet.EMPTY.value);
        }
        for (int i = 0; i < 15; i++) {
            if (i < calculationValues.length()) {
                band.add(String.valueOf(calculationValues.charAt(i)));
            } else {
                band.add(Alphabet.EMPTY.value);
            }
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
        System.out.println("Current State: " + (currentState != null ? currentState.toString() : ""));
        StringBuilder stringBuilderBand = new StringBuilder();
        StringBuilder stringBuilderIndex = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            if (i == headPosition) {
                if (band.get(i).length() == 1) {
                    stringBuilderBand.append(ANSI_GREEN + " | ").append(band.get(i)).append(" " + ANSI_RESET);
                } else {
                    stringBuilderBand.append(ANSI_GREEN + " | ").append(band.get(i)).append(ANSI_RESET);
                }
            } else {
                if (band.get(i).length() == 1) {
                    stringBuilderBand.append(" | ").append(band.get(i)).append(" ");
                } else {
                    stringBuilderBand.append(" | ").append(band.get(i));
                }
            }
        }

        for (int i = 0; i < 30; i++) {
            if (i == headPosition) {
                if ((String.valueOf(i)).length() == 1) {
                    stringBuilderIndex.append(ANSI_GREEN + " | ").append(i).append(" " + ANSI_RESET);
                } else {
                    stringBuilderIndex.append(ANSI_GREEN + " | ").append(i).append(ANSI_RESET);
                }
            } else {
                if ((String.valueOf(i)).length() == 1) {
                    stringBuilderIndex.append(ANSI_GREY + " | ").append(i).append(" " + ANSI_RESET);
                } else {
                    stringBuilderIndex.append(ANSI_GREY + " | ").append(i).append(ANSI_RESET);
                }
            }
        }
        System.out.println("Band:");
        System.out.println(stringBuilderBand);
        System.out.println(stringBuilderIndex);
        System.out.println("Amount of calculations: " + calculationIndex);
    }
}
