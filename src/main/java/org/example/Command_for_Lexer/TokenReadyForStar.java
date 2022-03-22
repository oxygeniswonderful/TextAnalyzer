package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;

public class TokenReadyForStar implements ICommand{
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.setTokenName("star");
        lexerContext.append(lexerContext.getBuffer().toString().toCharArray()[lexerContext.getBuffer().length()]);
        lexerContext.cleanBuffer();
        lexerContext.appendToBuffer(symbol);
    }
}
