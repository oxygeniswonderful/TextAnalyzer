package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;

public class TokenReadyForLineBreak implements ICommand{
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.setTokenName("LINE BREAK");
        lexerContext.append(symbol);
        lexerContext.cleanBuffer();
    }
}
