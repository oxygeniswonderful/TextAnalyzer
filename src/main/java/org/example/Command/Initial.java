package org.example.Command;

import org.example.Format.LexerContext;

public class Initial implements ICommand {
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.appendToBuffer(symbol);
    }
}
