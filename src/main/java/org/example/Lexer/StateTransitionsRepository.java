package org.example.Lexer;

import org.example.Pair;
import org.example.Format.State;

import java.util.HashMap;
import java.util.Map;

public class StateTransitionsRepository {
    private final Map<Pair<State, Character>, State> stateTransitions = new HashMap<>();

    public StateTransitionsRepository() {
        //initial
        stateTransitions.put(new Pair<>(new State("initial"), null), null);
        stateTransitions.put(new Pair<>(new State("initial"), ' '), new State("spacing"));
        stateTransitions.put(new Pair<>(new State("initial"), '/'), new State("slash"));
        stateTransitions.put(new Pair<>(new State("initial"), '{'), null);
        stateTransitions.put(new Pair<>(new State("initial"), '}'), null);
        stateTransitions.put(new Pair<>(new State("initial"), '('), null);
        stateTransitions.put(new Pair<>(new State("initial"), ')'), null);
        stateTransitions.put(new Pair<>(new State("initial"), ';'), null);
        stateTransitions.put(new Pair<>(new State("initial"), '\n'), null);
        stateTransitions.put(new Pair<>(new State("initial"), '*'), new State("star"));
        stateTransitions.put(new Pair<>(new State("initial"), '"'), null);
        stateTransitions.put(new Pair<>(new State("initial"), 'f'), new State("f"));

        //f
        stateTransitions.put(new Pair<>(new State("f"), 'o'), new State("o"));
        stateTransitions.put(new Pair<>(new State("f"), null), null);

        //o
        stateTransitions.put(new Pair<>(new State("o"), 'r'), new State("r"));
        stateTransitions.put(new Pair<>(new State("o"), null), null);

        //r
        stateTransitions.put(new Pair<>(new State("r"), null), null);

        //spacing
        stateTransitions.put(new Pair<>(new State("spacing"), null), null);
        stateTransitions.put(new Pair<>(new State("spacing"), ' '), new State("spacing"));

        //char
        /*stateTransitions.put(new Pair<>(new State("char"), null), new State("char"));
        stateTransitions.put(new Pair<>(new State("char"), ' '), null);
        stateTransitions.put(new Pair<>(new State("char"), '/'), null);
        stateTransitions.put(new Pair<>(new State("char"), '{'), null);
        stateTransitions.put(new Pair<>(new State("char"), '}'), null);
        stateTransitions.put(new Pair<>(new State("char"), '('), null);
        stateTransitions.put(new Pair<>(new State("char"), ')'), null);
        stateTransitions.put(new Pair<>(new State("char"), ';'), null);
        stateTransitions.put(new Pair<>(new State("char"), '\n'), null);
        stateTransitions.put(new Pair<>(new State("char"), '*'), null);
        stateTransitions.put(new Pair<>(new State("char"), '"'), null); */

        //slash
        stateTransitions.put(new Pair<>(new State("slash"), null), null);
        stateTransitions.put(new Pair<>(new State("slash"), '/'), null);
        stateTransitions.put(new Pair<>(new State("slash"), '*'), null);

        //star
        stateTransitions.put(new Pair<>(new State("star"), null), null);
        stateTransitions.put(new Pair<>(new State("star"), '/'), null);
    }
    public State getNextState(State state, char symbol) {
        if (stateTransitions.get(new Pair<>(state, symbol)) == null) {
            return stateTransitions.get(new Pair<>(state, (Character) null));
        }
        return stateTransitions.get(new Pair<>(state, symbol));
    }
}