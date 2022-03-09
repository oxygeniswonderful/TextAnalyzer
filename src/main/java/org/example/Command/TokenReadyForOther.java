package org.example.Command;

import org.example.Format.LexerContext;
import org.example.Format.TokenBuilder;

public class TokenReadyForOther implements ICommand {
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        Determinant determineTokenName = new Determinant(lexerContext);
        lexerContext.setTokenName(determineTokenName.determineTokenName());
        TokenBuilder tokenBuilder = new TokenBuilder();
        tokenBuilder.buildToken(lexerContext, true, symbol);
    }
}
