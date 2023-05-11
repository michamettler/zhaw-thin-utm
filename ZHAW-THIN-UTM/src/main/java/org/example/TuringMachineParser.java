package org.example;

import org.example.model.State;
import org.example.model.Transition;
import org.example.model.composition.CompositionFrom;
import org.example.model.composition.CompositionTo;
import org.example.util.Alphabet;
import org.example.util.Direction;
import org.example.util.SymbolMapping;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class TuringMachineParser {

    private Iterator<String> code;
    private TuringMachine tm = new TuringMachine();

    public TuringMachineParser(String code) {
        if (code.charAt(0) != '0') {
            tm = new TuringMachine(code.charAt(0));
            code = code.substring(1);
        } else {
            tm = new TuringMachine();
        }

        this.code = Arrays.stream(code.split("")).iterator();
    }

    public void run() {
        do {
            CompositionFrom from = new CompositionFrom(new State(readState(), false), readSymbol());
            CompositionTo to = new CompositionTo(new State(readState(), false), readSymbol(), readDirection());
            Transition transition = new Transition(from, to);
            System.out.println(transition);

            checkTransition();
        } while (code.hasNext());
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

}
