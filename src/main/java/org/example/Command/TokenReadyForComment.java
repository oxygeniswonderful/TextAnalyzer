package org.example.Command;

import org.example.Format.LexerContext;
import org.example.Format.TokenBuilder;

public class TokenReadyForComment implements ICommand {
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.append(symbol);
        lexerContext.setTokenName("COMMENT");
        TokenBuilder tokenBuilder = new TokenBuilder();
        tokenBuilder.buildToken(lexerContext, false, symbol);

    }
}
