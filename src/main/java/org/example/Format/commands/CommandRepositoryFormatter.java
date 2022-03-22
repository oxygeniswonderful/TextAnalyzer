package org.example.Format.commands;

import org.example.Pair;
import org.example.Format.State;
import org.example.Token.IToken;
import org.example.Token.TokenImpl;

import java.util.HashMap;
import java.util.Map;

public class CommandRepositoryFormatter {
    private final Map<Pair<State, IToken>, ICommandFormatter> commands = new HashMap<>();

    public CommandRepositoryFormatter() {

        IToken rightBracket = new TokenImpl("RightBracket", "}");
        IToken leftBracket = new TokenImpl("LeftBracket", "{");
        IToken space = new TokenImpl("SPACE", " ");
        IToken semicolon = new TokenImpl("SEMICOLON", ";");
        IToken comment = new TokenImpl("COMMENT", "//");
        IToken multi_lineR = new TokenImpl("MULTI_LINE", "/*");
        IToken multi_lineL = new TokenImpl("MULTI_LINE", "*/");
        IToken line_break = new TokenImpl("LINE BREAK", "\n");
        IToken unknown = new TokenImpl("UNKNOWN", "\u0000");

        //State = 0
        commands.put(new Pair<>(new State("initial"), leftBracket), new LeftBracket());
        commands.put(new Pair<>(new State("initial"), space), new StandartState());
        commands.put(new Pair<>(new State("initial"), semicolon), new Semicolon());
        commands.put(new Pair<>(new State("initial"), comment), new StandartState());
        commands.put(new Pair<>(new State("initial"), multi_lineR), new StandartState());
        commands.put(new Pair<>(new State("initial"), multi_lineL), new MultiLineCommentEnd());
        commands.put(new Pair<>(new State("initial"), line_break), new StandartState());
        commands.put(new Pair<>(new State("initial"), rightBracket), new RightBracket());
        commands.put(new Pair<>(new State("initial"), null), new StandartState());
        commands.put(new Pair<>(new State("initial"), unknown), new StandartState());

        //State = Other
        commands.put(new Pair<>(new State("Other"), space), new StandartState());
        commands.put(new Pair<>(new State("Other"), rightBracket), new RightBracket());
        commands.put(new Pair<>(new State("Other"), leftBracket), new LeftBracket());
        commands.put(new Pair<>(new State("Other"), semicolon), new Semicolon());
        commands.put(new Pair<>(new State("Other"), comment), new StandartState());
        commands.put(new Pair<>(new State("Other"), multi_lineR), new StandartState());
        commands.put(new Pair<>(new State("Other"), null),new StandartState());

        //State = //
        commands.put(new Pair<>(new State("COMMENT"), line_break), new LineBreak());
        commands.put(new Pair<>(new State("COMMENT"), leftBracket), new StandartState());
        commands.put(new Pair<>(new State("COMMENT"), rightBracket), new StandartState());
        commands.put(new Pair<>(new State("COMMENT"), space), new StandartState());
        commands.put(new Pair<>(new State("COMMENT"), semicolon), new StandartState());
        commands.put(new Pair<>(new State("COMMENT"), multi_lineL), new StandartState());
        commands.put(new Pair<>(new State("COMMENT"), multi_lineR), new StandartState());
        commands.put(new Pair<>(new State("COMMENT"), comment), new StandartState());
        commands.put(new Pair<>(new State("COMMENT"), null), new StandartState());

        //State = }
        commands.put(new Pair<>(new State("RightBracket"), rightBracket), new RightBracket());
        commands.put(new Pair<>(new State("RightBracket"), leftBracket), new LeftBracket());
        commands.put(new Pair<>(new State("RightBracket"), space), new StandartState());
        commands.put(new Pair<>(new State("RightBracket"), semicolon), new Semicolon());
        commands.put(new Pair<>(new State("RightBracket"), comment), new StandartState());
        commands.put(new Pair<>(new State("RightBracket"), multi_lineR), new StandartState());
        commands.put(new Pair<>(new State("RightBracket"), null), new StandartState());

        //State = {
        commands.put(new Pair<>(new State("LeftBracket"), rightBracket), new RightBracket());
        commands.put(new Pair<>(new State("LeftBracket"), leftBracket), new LeftBracket());
        commands.put(new Pair<>(new State("LeftBracket"), space), new StandartState());
        commands.put(new Pair<>(new State("LeftBracket"), comment), new StandartState());
        commands.put(new Pair<>(new State("LeftBracket"), semicolon), new Semicolon());
        commands.put(new Pair<>(new State("LeftBracket"), multi_lineR), new StandartState());
        commands.put(new Pair<>(new State("LeftBracket"), null), new StandartState());

        //State = /*
        commands.put(new Pair<>(new State("MULTI_LINE_R"), rightBracket), new StandartState());
        commands.put(new Pair<>(new State("MULTI_LINE_R"), leftBracket), new StandartState());
        commands.put(new Pair<>(new State("MULTI_LINE_R"), space), new StandartState());
        commands.put(new Pair<>(new State("MULTI_LINE_R"), comment), new StandartState());
        commands.put(new Pair<>(new State("MULTI_LINE_R"), semicolon), new StandartState());
        commands.put(new Pair<>(new State("MULTI_LINE_R"), line_break), new StandartState());
        commands.put(new Pair<>(new State("MULTI_LINE_R"), null), new StandartState());
        commands.put(new Pair<>(new State("MULTI_LINE_R"), multi_lineL), new MultiLineCommentEnd());

        //State = ;
        commands.put(new Pair<>(new State("SEMICOLON"), space), new Semicolon());
        commands.put(new Pair<>(new State("SEMICOLON"), comment), new StandartState());
        commands.put(new Pair<>(new State("SEMICOLON"), multi_lineR), new StandartState());
        commands.put(new Pair<>(new State("SEMICOLON"), rightBracket), new RightBracket());
        commands.put(new Pair<>(new State("SEMICOLON"), leftBracket), new LeftBracket());
        commands.put(new Pair<>(new State("SEMICOLON"), null), new Semicolon());

        //State = SPACE
        commands.put(new Pair<>(new State("SPACE"), space), new EmptyState());
        commands.put(new Pair<>(new State("SPACE"), semicolon), new Semicolon());
        commands.put(new Pair<>(new State("SPACE"), comment), new StandartState());
        commands.put(new Pair<>(new State("SPACE"), multi_lineL), new MultiLineCommentEnd());
        commands.put(new Pair<>(new State("SPACE"), multi_lineR), new StandartState());
        commands.put(new Pair<>(new State("SPACE"), rightBracket), new RightBracket());
        commands.put(new Pair<>(new State("SPACE"), leftBracket), new LeftBracket());
        commands.put(new Pair<>(new State("SPACE"), null), new StandartState());
    }
    public ICommandFormatter getCommand(State state, IToken token) {
        if (commands.get(new Pair<>(state, token)) == null) {
            return commands.get(new Pair<>(state, null));
        }
        return commands.get(new Pair<>(state, token));
    }
}
