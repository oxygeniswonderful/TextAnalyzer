package org.example.Lexer.commands;

import org.example.Lexer.LexerContext;

public interface ICommand {
    void execute(char symbol, LexerContext lexerContext);
}
