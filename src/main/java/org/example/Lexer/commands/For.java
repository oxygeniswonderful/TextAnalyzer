package org.example.Lexer.commands;

import org.example.Lexer.LexerContext;

public class For implements ICommand{
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.setTokenName("for");
        lexerContext.appendToBuffer(symbol);
    }
}
