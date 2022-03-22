package org.example.Format;

import org.example.Pair;
import org.example.Token.IToken;
import org.example.Token.TokenImpl;

import java.util.HashMap;
import java.util.Map;

public class StateTransitionsRepositoryFormatter {
    private Map<Pair<State, IToken>, State> stateTransitionsFormatter = new HashMap<>();

    public StateTransitionsRepositoryFormatter() {

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
        stateTransitionsFormatter.put(new Pair<>(new State("initial"), leftBracket), new State("LeftBracket"));
        stateTransitionsFormatter.put(new Pair<>(new State("initial"), space), new State("SPACE"));
        stateTransitionsFormatter.put(new Pair<>(new State("initial"), semicolon), new State("SEMICOLON"));
        stateTransitionsFormatter.put(new Pair<>(new State("initial"), comment), new State("COMMENT"));
        stateTransitionsFormatter.put(new Pair<>(new State("initial"), multi_lineL), new State("MULTI_LINE_L"));
        stateTransitionsFormatter.put(new Pair<>(new State("initial"), multi_lineR), new State("MULTI_LINE_R"));
        stateTransitionsFormatter.put(new Pair<>(new State("initial"), rightBracket), new State("RightBracket"));
        stateTransitionsFormatter.put(new Pair<>(new State("initial"), null), new State("Other"));
        stateTransitionsFormatter.put(new Pair<>(new State("initial"), unknown), new State("Other"));

        //State = Other
        stateTransitionsFormatter.put(new Pair<>(new State("Other"), space), new State("SPACE"));
        stateTransitionsFormatter.put(new Pair<>(new State("Other"), rightBracket), new State("RightBracket"));
        stateTransitionsFormatter.put(new Pair<>(new State("Other"), leftBracket), new State("LeftBracket"));
        stateTransitionsFormatter.put(new Pair<>(new State("Other"), semicolon), new State("SEMICOLON"));
        stateTransitionsFormatter.put(new Pair<>(new State("Other"), comment), new State("COMMENT"));
        stateTransitionsFormatter.put(new Pair<>(new State("Other"), multi_lineR), new State("MULTI_LINE_R"));
        stateTransitionsFormatter.put(new Pair<>(new State("Other"), null), new State("Other"));

        //State = //
        stateTransitionsFormatter.put(new Pair<>(new State("COMMENT"), line_break), new State("LINE_BREAK"));
        stateTransitionsFormatter.put(new Pair<>(new State("COMMENT"), rightBracket), new State("COMMENT"));
        stateTransitionsFormatter.put(new Pair<>(new State("COMMENT"), leftBracket), new State("COMMENT"));
        stateTransitionsFormatter.put(new Pair<>(new State("COMMENT"), space), new State("COMMENT"));
        stateTransitionsFormatter.put(new Pair<>(new State("COMMENT"), semicolon), new State("COMMENT"));
        stateTransitionsFormatter.put(new Pair<>(new State("COMMENT"), multi_lineL), new State("COMMENT"));
        stateTransitionsFormatter.put(new Pair<>(new State("COMMENT"), multi_lineR), new State("COMMENT"));
        stateTransitionsFormatter.put(new Pair<>(new State("COMMENT"), comment), new State("COMMENT"));
        stateTransitionsFormatter.put(new Pair<>(new State("COMMENT"), null), new State("COMMENT"));

        //State = {
        stateTransitionsFormatter.put(new Pair<>(new State("LeftBracket"), leftBracket), new State("LeftBracket"));
        stateTransitionsFormatter.put(new Pair<>(new State("LeftBracket"), rightBracket), new State("RightBracket"));
        stateTransitionsFormatter.put(new Pair<>(new State("LeftBracket"), space), new State("SPACE"));
        stateTransitionsFormatter.put(new Pair<>(new State("LeftBracket"), comment), new State("COMMENT"));
        stateTransitionsFormatter.put(new Pair<>(new State("LeftBracket"), multi_lineR), new State("MULTI_LINE_R"));
        stateTransitionsFormatter.put(new Pair<>(new State("LeftBracket"), semicolon), new State("SEMICOLON"));
        stateTransitionsFormatter.put(new Pair<>(new State("LeftBracket"), null), new State("Other"));

        //State = }
        stateTransitionsFormatter.put(new Pair<>(new State("RightBracket"), rightBracket), new State("RightBracket"));
        stateTransitionsFormatter.put(new Pair<>(new State("RightBracket"), leftBracket), new State("LeftBracket"));
        stateTransitionsFormatter.put(new Pair<>(new State("RightBracket"), space), new State("SPACE"));
        stateTransitionsFormatter.put(new Pair<>(new State("RightBracket"), comment), new State("COMMENT"));
        stateTransitionsFormatter.put(new Pair<>(new State("RightBracket"), multi_lineR), new State("MULTI_LINE_R"));
        stateTransitionsFormatter.put(new Pair<>(new State("RightBracket"), semicolon), new State("SEMICOLON"));
        stateTransitionsFormatter.put(new Pair<>(new State("RightBracket"), null), new State("Other"));

        //State = /*
        stateTransitionsFormatter.put(new Pair<>(new State("MULTI_LINE_R"), rightBracket), new State("MULTI_LINE_R"));
        stateTransitionsFormatter.put(new Pair<>(new State("MULTI_LINE_R"), comment), new State("MULTI_LINE_R"));
        stateTransitionsFormatter.put(new Pair<>(new State("MULTI_LINE_R"), space), new State("MULTI_LINE_R"));
        stateTransitionsFormatter.put(new Pair<>(new State("MULTI_LINE_R"), semicolon), new State("MULTI_LINE_R"));
        stateTransitionsFormatter.put(new Pair<>(new State("MULTI_LINE_R"), leftBracket), new State("MULTI_LINE_R"));
        stateTransitionsFormatter.put(new Pair<>(new State("MULTI_LINE_R"), line_break), new State("MULTI_LINE_R"));
        stateTransitionsFormatter.put(new Pair<>(new State("MULTI_LINE_R"), null), new State("MULTI_LINE_R"));
        stateTransitionsFormatter.put(new Pair<>(new State("MULTI_LINE_R"), multi_lineL), new State("MULTI_LINE_L"));

        //State = ;
        stateTransitionsFormatter.put(new Pair<>(new State("SEMICOLON"), space), new State("SEMICOLON"));
        stateTransitionsFormatter.put(new Pair<>(new State("SEMICOLON"), null), new State("SEMICOLON"));
        stateTransitionsFormatter.put(new Pair<>(new State("SEMICOLON"), comment), new State("COMMENT"));
        stateTransitionsFormatter.put(new Pair<>(new State("SEMICOLON"), multi_lineR), new State("MULTI_LINE_R"));
        stateTransitionsFormatter.put(new Pair<>(new State("SEMICOLON"), rightBracket), new State("RightBracket"));
        stateTransitionsFormatter.put(new Pair<>(new State("SEMICOLON"), leftBracket), new State("LeftBracket"));

        //State = SPACE
        stateTransitionsFormatter.put(new Pair<>(new State("SPACE"), space), new State("SPACE"));
        stateTransitionsFormatter.put(new Pair<>(new State("SPACE"), comment), new State("COMMENT"));
        stateTransitionsFormatter.put(new Pair<>(new State("SPACE"), semicolon), new State("SEMICOLON"));
        stateTransitionsFormatter.put(new Pair<>(new State("SPACE"), multi_lineR), new State("MULTI_LINE_R"));
        stateTransitionsFormatter.put(new Pair<>(new State("SPACE"), multi_lineL), new State("MULTI_LINE_L"));
        stateTransitionsFormatter.put(new Pair<>(new State("SPACE"), rightBracket), new State("RightBracket"));
        stateTransitionsFormatter.put(new Pair<>(new State("SPACE"), leftBracket), new State("LeftBracket"));
        stateTransitionsFormatter.put(new Pair<>(new State("SPACE"), null), new State("Other"));

    }

    public State getNextState(State state, IToken token) {
        if (stateTransitionsFormatter.get(new Pair<>(state, token)) == null) {
            return stateTransitionsFormatter.get(new Pair<>(state, (IToken) null));
        }
        return stateTransitionsFormatter.get(new Pair<>(state, token));
    }
}
