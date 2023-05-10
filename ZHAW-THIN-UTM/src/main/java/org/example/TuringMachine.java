package org.example;

import org.example.model.State;
import org.example.model.composition.CompositionFrom;
import org.example.util.Alphabet;
import org.example.util.SymbolMapping;

import java.util.*;

public class TuringMachine {
    private LinkedList<Alphabet> band = new LinkedList<>();

    private Iterator<String> code;

    public TuringMachine(String code) {
        this.code = Arrays.stream(code.split("")).iterator();
    }

    public void run() {
        while(code.hasNext()) {
            CompositionFrom from = new CompositionFrom(new State(readState(), false), readSymbol());
            System.out.println("q" + from.getState().getStateNumber() + " read value " + from.getReadValue());
        }
    }

    private int readState() {
        int index = 0;
        while (code.hasNext() && !code.next().equals("1")) {
            index++;
        }
        return index;
    }

    private SymbolMapping readSymbol() {
        StringBuilder symbols = new StringBuilder();
        String nextSymbol = code.next();
        while (code.hasNext() && !nextSymbol.equals("1")) {
            symbols.append(nextSymbol);
            nextSymbol = code.next();
        }
        return SymbolMapping.findEnum(symbols.toString());
    }


}
