package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;

public class TokenReadyForRightBracket implements ICommand{
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.setTokenName("RightBracket");
        lexerContext.append(symbol);
        lexerContext.cleanBuffer();
    }
}