package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;

public class TokenReadyForLetterAndDigit implements ICommand{
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
       lexerContext.setTokenName("LeterOrDigit");
       lexerContext.cleanBuffer();
       lexerContext.appendToBuffer(symbol);
    }
}
