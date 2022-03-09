package org.example.Command;

import org.example.Format.LexerContext;

public class Slash implements ICommand {
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.append(symbol);
    }
}
