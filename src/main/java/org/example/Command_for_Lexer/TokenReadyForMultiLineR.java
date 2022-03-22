package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;

public class TokenReadyForMultiLineR implements ICommand{
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.append(symbol);
        lexerContext.setTokenName("MULTI_LINE_R");
        lexerContext.cleanBuffer();
    }
}
