package org.example;

public class TokenImpl implements IToken{

    private final String tokenName;
    private final String lexeme;

    public TokenImpl(String tokenName, String lexeme) {
        this.tokenName = tokenName;
        this.lexeme = lexeme;
    }

    @Override
    public String getName() {
        return tokenName;
    }

    @Override
    public String getLexeme() {
        return lexeme;
    }
}
