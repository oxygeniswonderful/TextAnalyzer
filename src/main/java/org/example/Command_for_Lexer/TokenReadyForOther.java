package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;
import org.example.Lexer.TokenBuilder;

public class TokenReadyForOther implements ICommand {
    @Override
    public void execute(char symbol, LexerContext lexerContext) {
        Determinant determineTokenName = new Determinant(lexerContext);
        lexerContext.setTokenName(determineTokenName.determineTokenName());
        TokenBuilder tokenBuilder = new TokenBuilder();
        //System.out.println(lexerContext.getBuffer() + " буффер");
        //System.out.println(lexerContext.getTokenLexeme() + " лексема");
        tokenBuilder.buildToken(lexerContext, true, symbol);
    }
}
