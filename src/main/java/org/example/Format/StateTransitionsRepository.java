package org.example.Format;

import org.example.Command.Pair;

import java.util.HashMap;
import java.util.Map;

public class StateTransitionsRepository {
    private Map<Pair<State, Character>, State> stateTransitions = new HashMap<>();

    public StateTransitionsRepository() {
        //State = 0
        stateTransitions.put(new Pair<>(new State("initial"), ' '), new State("END"));
        stateTransitions.put(new Pair<>(new State("initial"), '/'), new State("SLASH"));
        stateTransitions.put(new Pair<>(new State("initial"), '±'), new State("LetterDigit"));
        stateTransitions.put(new Pair<>(new State("initial"), '{'), new State("END"));
        stateTransitions.put(new Pair<>(new State("initial"), '}'), new State("END"));
        stateTransitions.put(new Pair<>(new State("initial"), ';'), new State("END"));
        stateTransitions.put(new Pair<>(new State("initial"), '\n'), new State("END"));
        stateTransitions.put(new Pair<>(new State("initial"), null), new State("OTHER"));

        //State = /
        stateTransitions.put(new Pair<>(new State("SLASH"), '/'), new State("END"));
        stateTransitions.put(new Pair<>(new State("SLASH"), null), new State("END"));
        stateTransitions.put(new Pair<>(new State("SLASH"), '*'), new State("OTHER"));
        stateTransitions.put(new Pair<>(new State("SLASH"), '±'), new State("END"));
        stateTransitions.put(new Pair<>(new State("SLASH"), ' '), new State("END"));

        //State = Letter or Digit
        stateTransitions.put(new Pair<>(new State("LetterDigit"), '±'), new State("LetterDigit"));
        stateTransitions.put(new Pair<>(new State("LetterDigit"), null), new State("END"));

        //State = Other
        stateTransitions.put(new Pair<>(new State("OTHER"), null), new State("OTHER"));
        stateTransitions.put(new Pair<>(new State("OTHER"), ' '), new State("END"));
        stateTransitions.put(new Pair<>(new State("OTHER"), '\n'), new State("END"));
        stateTransitions.put(new Pair<>(new State("OTHER"), '±'), new State("END"));
        stateTransitions.put(new Pair<>(new State("OTHER"), '{'),new State("END"));
        stateTransitions.put(new Pair<>(new State("OTHER"), '}'),new State("END"));
        stateTransitions.put(new Pair<>(new State("OTHER"), ';'), new State("END"));
        stateTransitions.put(new Pair<>(new State("OTHER"), '*'), new State("END"));

    }
    public State getNextState(State state, char symbol) {
        if (stateTransitions.get(new Pair<>(state, symbol)) == null) {
            if (Character.isLetterOrDigit(symbol)) {
                return stateTransitions.get(new Pair<>(state, '±'));
            }
            return stateTransitions.get(new Pair<>(state, null));
        }
        return stateTransitions.get(new Pair<>(state, symbol));
    }
}