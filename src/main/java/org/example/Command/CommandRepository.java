package org.example.Command;
import org.example.Format.State;

import java.util.HashMap;
import java.util.Map;

public class CommandRepository {
    private Map<Pair<State, Character>, ICommand> commands = new HashMap<>();

    public CommandRepository() {
        //initial
        commands.put(new Pair<>(new State("initial"), ' '), new TokenReady());
        commands.put(new Pair<>(new State("initial"), '/'), new Slash());
        commands.put(new Pair<>(new State("initial"), '±'), new LetterDigit());
        commands.put(new Pair<>(new State("initial"), '{'), new TokenReady());
        commands.put(new Pair<>(new State("initial"), '}'), new TokenReady());
        commands.put(new Pair<>(new State("initial"), ';'), new TokenReady());
        commands.put(new Pair<>(new State("initial"), '\n'), new TokenReady());
        commands.put(new Pair<>(new State("initial"), null), new Other());

        //SLASH
        commands.put(new Pair<>(new State("SLASH"),null), new TokenReadyForOther());
        commands.put(new Pair<>(new State("SLASH"), '/'), new TokenReadyForComment());
        commands.put(new Pair<>(new State("SLASH"), '*'), new Other());
        commands.put(new Pair<>(new State("SLASH"), '±'), new TokenReadyForOther());
        commands.put(new Pair<>(new State("SLASH"), ' '), new TokenReadyForOther());

        //Letter or digit
        commands.put(new Pair<>(new State("LetterDigit"),'±'), new LetterDigit());
        commands.put(new Pair<>(new State("LetterDigit"), null), new TokenReadyForOther());
        //OTHER
        commands.put(new Pair<>(new State("OTHER"), null), new Other());
        commands.put(new Pair<>(new State("OTHER"), ' '), new TokenReadyForOther());
        commands.put(new Pair<>(new State("OTHER"), '\n'), new TokenReadyForOther());
        commands.put(new Pair<>(new State("OTHER"), '±'), new TokenReadyForOther());
        commands.put(new Pair<>(new State("OTHER"), '{'), new TokenReadyForOther());
        commands.put(new Pair<>(new State("OTHER"), '}'), new TokenReadyForOther());
        commands.put(new Pair<>(new State("OTHER"), ';'), new TokenReadyForOther());
        commands.put(new Pair<>(new State("OTHER"), '*'), new TokenReady());

    }
    public ICommand getCommand(State state, char symbol) {
        if (commands.get(new Pair<>(state, symbol)) == null) {
            if (Character.isLetterOrDigit(symbol)) {
                return commands.get(new Pair<>(state, '±'));
            }

            return commands.get(new Pair<>(state, null));
        }
        return commands.get(new Pair<>(state, symbol));
    }
}
