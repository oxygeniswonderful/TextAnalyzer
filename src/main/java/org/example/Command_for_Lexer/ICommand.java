package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;

public interface ICommand {
    void execute(char symbol, LexerContext lexerContext);
}
