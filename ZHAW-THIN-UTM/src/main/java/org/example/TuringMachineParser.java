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

public class TuringMachineParser {

    private Iterator<String> code;
    private TuringMachine tm;
    private Mode mode;
    private List<Transition> transitions = new ArrayList<>();

    public TuringMachineParser(String code, Mode mode) {
        this.mode = mode;

        if (code.charAt(0) != '0') {
            tm = new TuringMachine(code.charAt(0));
            code = code.substring(1);
        } else {
            tm = new TuringMachine();
        }

        this.code = Arrays.stream(code.split("")).iterator();
    }

    public void parse() {
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
        System.out.println("States:");
        for (Transition transition : transitions) {
            System.out.println(transition.toString());
            System.out.println("\n\n");
        }
    }

    public void run() {
        //TODO
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
