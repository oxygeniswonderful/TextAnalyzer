package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;
import org.example.Lexer.TokenBuilder;

public class TokenReadyForComment implements ICommand {
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        lexerContext.append(symbol);
        lexerContext.setTokenName("COMMENT");
        TokenBuilder tokenBuilder = new TokenBuilder();
        tokenBuilder.buildToken(lexerContext, false, symbol);

    }
}
