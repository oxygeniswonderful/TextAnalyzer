package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;

public class Other implements ICommand {
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        //System.out.println(symbol + " symbol");
        lexerContext.append(symbol);
    }
}
