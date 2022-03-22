package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;

public class TokenReadyForLeftBracket implements ICommand{
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.setTokenName("LeftBracket");
        lexerContext.append(symbol);
        lexerContext.cleanBuffer();
    }
}
