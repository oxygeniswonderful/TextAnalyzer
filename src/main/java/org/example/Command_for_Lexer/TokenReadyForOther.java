package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;

public class TokenReadyForOther implements ICommand {
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.setTokenName("OTHER");
        lexerContext.cleanBuffer();
        lexerContext.appendToBuffer(symbol);;
    }
}
