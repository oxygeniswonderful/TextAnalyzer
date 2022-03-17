package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;
import org.example.Lexer.TokenBuilder;

public class TokenReady implements ICommand {

    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.append(symbol);
        Determinant determineTokenName = new Determinant(lexerContext);
        lexerContext.setTokenName(determineTokenName.determineTokenName());
        TokenBuilder tokenBuilder = new TokenBuilder();
        tokenBuilder.buildToken(lexerContext, false, symbol);
    }
}
