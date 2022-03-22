package org.example.Command_for_Lexer;
import org.example.Format.State;

import java.util.HashMap;
import java.util.Map;

public class CommandRepository {
    private Map<Pair<State, Character>, ICommand> commands = new HashMap<>();

    public CommandRepository() {
        //initial
        commands.put(new Pair<>(new State("initial"), ' '), new TokenReadyForSpace());
        commands.put(new Pair<>(new State("initial"), '/'), new Temporal());
        commands.put(new Pair<>(new State("initial"), '±'), new Other());
        commands.put(new Pair<>(new State("initial"), '{'), new TokenReadyForLeftBracket());
        commands.put(new Pair<>(new State("initial"), '}'), new TokenReadyForRightBracket());
        commands.put(new Pair<>(new State("initial"), ';'), new TokenReadyForSemicolon());
        commands.put(new Pair<>(new State("initial"), '\n'), new TokenReadyForLineBreak());
        commands.put(new Pair<>(new State("initial"), null), new Other());
        commands.put(new Pair<>(new State("initial"), '*'), new Temporal());

        //SLASH
        commands.put(new Pair<>(new State("SLASH"),null), new TokenReadyForSlash());
        commands.put(new Pair<>(new State("SLASH"), '/'), new TokenReadyForSlash());
        commands.put(new Pair<>(new State("SLASH"), '*'), new TokenReadyForMultiLineR());
        commands.put(new Pair<>(new State("SLASH"), '±'), new TokenReadyForSlash());
        commands.put(new Pair<>(new State("SLASH"), ' '), new TokenReadyForSlash());
        commands.put(new Pair<>(new State("SLASH"), '{'), new TokenReadyForSlash());
        commands.put(new Pair<>(new State("SLASH"), '}'), new TokenReadyForSlash());
        commands.put(new Pair<>(new State("SLASH"), '\n'), new TokenReadyForSlash());
        commands.put(new Pair<>(new State("SLASH"), ';'), new TokenReadyForSlash());


        //Letter or digit
        commands.put(new Pair<>(new State("LetterDigit"),'±'), new Other());
        commands.put(new Pair<>(new State("LetterDigit"), null), new TokenReadyForLetterAndDigit());

        //OTHER
        commands.put(new Pair<>(new State("OTHER"), null), new Other());
        commands.put(new Pair<>(new State("OTHER"), ' '), new TokenReadyForOther());
        commands.put(new Pair<>(new State("OTHER"), '\n'), new TokenReadyForOther());
        commands.put(new Pair<>(new State("OTHER"), '±'), new TokenReadyForOther());
        commands.put(new Pair<>(new State("OTHER"), '{'), new TokenReadyForOther());
        commands.put(new Pair<>(new State("OTHER"), '}'), new TokenReadyForOther());
        commands.put(new Pair<>(new State("OTHER"), ';'), new TokenReadyForOther());
        commands.put(new Pair<>(new State("OTHER"), '*'), new TokenReady());

        //STAR
        commands.put(new Pair<>(new State("STAR"), '/'), new TokenReadyForMultiLineL());
        commands.put(new Pair<>(new State("STAR"), '{'), new TokenReadyForStar());
        commands.put(new Pair<>(new State("STAR"), '}'), new TokenReadyForStar());
        commands.put(new Pair<>(new State("STAR"), ' '), new TokenReadyForStar());
        commands.put(new Pair<>(new State("STAR"), '*'), new TokenReadyForStar());
        commands.put(new Pair<>(new State("STAR"), '\n'), new TokenReadyForStar());
        commands.put(new Pair<>(new State("STAR"), ';'), new TokenReadyForStar());
        commands.put(new Pair<>(new State("STAR"), '±'), new TokenReadyForStar());
        commands.put(new Pair<>(new State("STAR"), null), new TokenReadyForStar());

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
