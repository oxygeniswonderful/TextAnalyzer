package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;

public class TokenReadyForSlash implements ICommand {
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.setTokenName("slash");
        lexerContext.append(lexerContext.getBuffer().toString().toCharArray()[lexerContext.getBuffer().length()]);
        lexerContext.cleanBuffer();
        lexerContext.appendToBuffer(symbol);
    }
}
