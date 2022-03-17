package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;

public class TokenReadyForSemicolon implements ICommand{
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.append(symbol);
        lexerContext.setTokenName("Semicolon");
    }
}
