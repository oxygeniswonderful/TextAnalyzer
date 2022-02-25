package org.example;

public interface ICommand {
    void execute(char symbol, LexerContext lexerContext);
}
