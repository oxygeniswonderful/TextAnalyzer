package org.example.Lexer.commands;

import org.example.Lexer.LexerContext;

public class AppendPostpone implements ICommand {
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.appendToBuffer(symbol);
    }
}
