package org.example.Command;

import org.example.Format.LexerContext;

public interface ICommand {
    void execute(char symbol, LexerContext lexerContext);
}
