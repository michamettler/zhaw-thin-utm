package org.example;

import org.example.model.State;
import org.example.model.Transition;
import org.example.model.composition.CompositionFrom;
import org.example.model.composition.CompositionTo;
import org.example.util.Alphabet;
import org.example.util.Direction;
import org.example.util.Mode;
import org.example.util.SymbolMapping;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TuringMachineParser {

    private Iterator<String> code;
    private String calculationValues = "";
    private TuringMachine tm;
    private Mode mode;
    private List<Transition> transitions = new ArrayList<>();

    public TuringMachineParser(String input, Mode mode) {
        this.mode = mode;

        if (input.charAt(0) != '0') {
            tm = new TuringMachine(Integer.parseInt(String.valueOf(input.charAt(0))));
            input = input.substring(1);
        } else {
            tm = new TuringMachine();
        }

        List<String> splittedInput = new ArrayList<>(Arrays.asList(input.split("111")));
        this.code = Arrays.stream(splittedInput.get(0).split("")).iterator();
        if (splittedInput.size() > 1) {
            splittedInput.remove(0);
            for (String calcValue : splittedInput) {
                this.calculationValues += calcValue;
            }
        }
    }

    public void parse() {
        System.out.println("\n");
        do {
            CompositionFrom from = new CompositionFrom(new State(readState()), readSymbol());
            CompositionTo to = new CompositionTo(new State(readState()), readSymbol(), readDirection());
            Transition transition = new Transition(from, to);
            transitions.add(transition);

            checkTransition();
        } while (code.hasNext());

        if (tm.getGoedelNumber() != 0) {
            System.out.println("TM Nr.:" + tm.getGoedelNumber());
        }
        System.out.println("States:");
        for (Transition transition : transitions) {
            System.out.println(transition.toString());
        }
    }

    public void run() throws InterruptedException {
        tm.initializeTape(calculationValues);

        boolean isNotEndState = true;
        tm.setCurrentState(new State(1));
        log();

        while(isNotEndState) {
            List<Transition> currentTransitions = transitions.stream().filter(item ->
                    item.getCompositionFrom().getState().getStateNumber() == tm.getCurrentState().getStateNumber()).toList();

            String currentSymbol = tm.readSymbol();
            var foundTransistion = currentTransitions.stream().filter(item ->
                    item.getCompositionFrom().getReadValue().value.equals(currentSymbol)).findAny();

            if (foundTransistion.isPresent()) {
                tm.writeSymbol(foundTransistion.get().getCompositionTo().getDirection(),
                        foundTransistion.get().getCompositionTo().getWriteValue());
                tm.setCurrentState(foundTransistion.get().getCompositionTo().getState());
                tm.adjustCalculationIndex();
                log();
            } else {
                isNotEndState = false;
            }
        }

        System.out.println("\nTM cant get further");
        if (mode == Mode.RUN) {
            tm.print();
        }
    }

    private int readState() {
        int index = 0;
        while (code.hasNext() && !code.next().equals("1")) {
            index++;
        }
        return index;
    }

    private Alphabet readSymbol() {
        StringBuilder symbols = new StringBuilder();
        String nextSymbol = code.next();

        while (code.hasNext() && !nextSymbol.equals("1")) {
            symbols.append(nextSymbol);
            nextSymbol = code.next();
        }

        return Alphabet.valueOf(Objects.requireNonNull(SymbolMapping.findEnum(symbols.toString())).name());
    }

    private Direction readDirection() {
        StringBuilder symbols = new StringBuilder();
        String nextSymbol = code.next();

        while (code.hasNext() && !nextSymbol.equals("1")) {
            symbols.append(nextSymbol);
            nextSymbol = code.next();
        }

        if (!code.hasNext() && !nextSymbol.equals("1")) {
            symbols.append(nextSymbol);
        }

        return Direction.findEnum(symbols.toString());
    }

    private void checkTransition() {
        if (code.hasNext() && !code.next().equals("1")) {
            throw new IllegalArgumentException();
        }
    }

    private void log() throws InterruptedException {
        if (mode == Mode.STEP) {
            tm.print();
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
