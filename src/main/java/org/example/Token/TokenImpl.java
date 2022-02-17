package org.example.Token;

public class TokenImpl implements IToken{

    private final String token;
    private final String lexeme;

    public TokenImpl(String token, String lexeme) {
        this.token = token;
        this.lexeme = lexeme;
    }

    public TokenImpl(String lexeme) {
        this.lexeme = lexeme;
        this.token = String.valueOf(Token.EOF);
    }

    @Override
    public String getName() {
        return token;
    }

    @Override
    public String getLexeme() {
        return lexeme;
    }
}
