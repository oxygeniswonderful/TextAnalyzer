package org.example.Lexer;

import org.example.Token.IToken;
import org.example.Token.TokenImpl;

public class LexerContext {
    private String tokenName;
    private StringBuilder tokenLexeme;
    private StringBuilder buffer;
    private IToken token;

    public LexerContext() {
        this.tokenName = "";
        this.tokenLexeme = new StringBuilder();
        this.buffer = new StringBuilder();
    }


    public String getTokenName() {
        return tokenName;
    }

    public StringBuilder getTokenLexeme() {
        return tokenLexeme;
    }

    public void clean() {
        tokenLexeme = new StringBuilder();
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public void append(char symbol) {
        tokenLexeme.append(symbol);
    }

    public void appendToBuffer(char symbol) {
        buffer.append(symbol);
    }

    public void cleanBuffer() {
        buffer = new StringBuilder();
    }

    public StringBuilder getBuffer(){
        return buffer;
    }

    public void setToken(String tokenName, StringBuilder tokenLexeme) {
        token = new TokenImpl(tokenName, tokenLexeme.toString());
    }

    @Override
    public String toString() {
        return "LexerContext{" +
                "tokenName='" + tokenName + '\'' +
                ", tokenLexeme=" + tokenLexeme +
                '}';
    }
}
