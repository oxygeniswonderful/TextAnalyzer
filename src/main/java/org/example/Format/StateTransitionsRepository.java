package org.example.Format;

import org.example.Command.Pair;

import java.util.HashMap;
import java.util.Map;

public class StateTransitionsRepository {
    private Map<Pair<State, Character>, State> stateTransitions = new HashMap<>();

    public StateTransitionsRepository() {
        //State = 0
        stateTransitions.put(new Pair<>(new State("initial"), '/'), new State("SLASH"));
        stateTransitions.put(new Pair<>(new State("initial"), '±'), new State("LetterDigit"));
        stateTransitions.put(new Pair<>(new State("initial"), null), new State("OTHER"));

        //State = /
        stateTransitions.put(new Pair<>(new State("SLASH"), '*'), new State("OTHER"));

        //State = Letter or Digit
        stateTransitions.put(new Pair<>(new State("LetterDigit"), '±'), new State("LetterDigit"));

        //State = Other
        stateTransitions.put(new Pair<>(new State("OTHER"), null), new State("OTHER"));

    }
    public State getNextState(State state, char symbol) {
        if (stateTransitions.get(new Pair<>(state, symbol)) == null) {
            if (Character.isLetterOrDigit(symbol)) {
                return stateTransitions.get(new Pair<>(state, '±'));
            }
            if (Tools.isLeftBrace(String.valueOf(symbol))) {
                return stateTransitions.get(new Pair<>(state, '{'));
            }
            if (Tools.isRightBrace(String.valueOf(symbol))) {
                return stateTransitions.get(new Pair<>(state, '}'));
            }
            return stateTransitions.get(new Pair<>(state, null));
        }
        return stateTransitions.get(new Pair<>(state, symbol));
    }
}
