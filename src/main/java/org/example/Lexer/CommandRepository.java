package org.example.Lexer;

import org.example.Format.State;
import org.example.Lexer.commands.AppendPostpone;
import org.example.Lexer.commands.Char;
import org.example.Lexer.commands.CloseBrace;
import org.example.Lexer.commands.CloseBracket;
import org.example.Lexer.commands.CloseMultilineComment;
import org.example.Lexer.commands.ICommand;
import org.example.Lexer.commands.NewLine;
import org.example.Lexer.commands.OneLineComment;
import org.example.Lexer.commands.OpenBrace;
import org.example.Lexer.commands.OpenBracket;
import org.example.Lexer.commands.OpenMultilineComment;
import org.example.Lexer.commands.QuoteMark;
import org.example.Lexer.commands.Semicolon;
import org.example.Lexer.commands.Space;
import org.example.Lexer.commands.Spaces;
import org.example.Pair;

import java.util.HashMap;
import java.util.Map;

public class CommandRepository {
    private final Map<Pair<State, Character>, ICommand> commands = new HashMap<>();

    public CommandRepository() {
        //initial
        commands.put(new Pair<>(new State("initial"), null), new Char());
        commands.put(new Pair<>(new State("initial"), ' '), new Space());
        commands.put(new Pair<>(new State("initial"), '/'), new Char());
        commands.put(new Pair<>(new State("initial"), '{'), new OpenBrace());
        commands.put(new Pair<>(new State("initial"), '}'), new CloseBrace());
        commands.put(new Pair<>(new State("initial"), '('), new OpenBracket());
        commands.put(new Pair<>(new State("initial"), ')'), new CloseBracket());
        commands.put(new Pair<>(new State("initial"), ';'), new Semicolon());
        commands.put(new Pair<>(new State("initial"), '\n'), new NewLine());
        commands.put(new Pair<>(new State("initial"), '*'), new Char());
        commands.put(new Pair<>(new State("initial"), '"'), new QuoteMark());

        //spacing
        commands.put(new Pair<>(new State("spacing"), null), new AppendPostpone());
        commands.put(new Pair<>(new State("spacing"), ' '), new Spaces());

        //slash
        commands.put(new Pair<>(new State("slash"), null), new AppendPostpone());
        commands.put(new Pair<>(new State("slash"), '/'), new OneLineComment());
        commands.put(new Pair<>(new State("slash"), '*'), new OpenMultilineComment());

        //star
        commands.put(new Pair<>(new State("star"), null), new AppendPostpone());
        commands.put(new Pair<>(new State("star"), '/'), new CloseMultilineComment());
    }
    public ICommand getCommand(State state, char symbol) {
        if (commands.get(new Pair<>(state, symbol)) == null) {
            return commands.get(new Pair<>(state, (Character) null));
        }
        return commands.get(new Pair<>(state, symbol));
    }
}
