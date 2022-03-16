package org.example.Token;

import java.util.Objects;

public class TokenImpl implements IToken{

    private final String token;
    private final String lexeme;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokenImpl)) return false;
        TokenImpl token1 = (TokenImpl) o;
        return Objects.equals(token, token1.token) && Objects.equals(lexeme, token1.lexeme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, lexeme);
    }

    public TokenImpl(String token, String lexeme) {
        this.token = token;
        this.lexeme = lexeme;
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
