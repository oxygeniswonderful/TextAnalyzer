package org.example.Lexer.commands;

import org.example.Lexer.LexerContext;

public class OneLineComment implements ICommand {
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.append(symbol);
        lexerContext.setTokenName("onelinecomment");
    }
}
