package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;

public class TokenReadyForSpace implements ICommand{
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.setTokenName("Space");
        lexerContext.append(symbol);
        lexerContext.cleanBuffer();
    }
}
