package org.example.Format;

import org.example.Token.IToken;
import org.example.Reader.IReader;
import org.example.Reader.ReaderException;
import org.example.Token.Token;
import org.example.Token.TokenImpl;


import java.util.ArrayDeque;
import java.util.Queue;

public class Lexer implements ILexer {

    private final IReader reader;
    private final Queue<String> lexemes = new ArrayDeque<>();
    private StringBuilder lexeme = new StringBuilder();
    private IToken readedToken;
    private String firstTokenStr;
    private String secondTokenStr;
    private int flag = 0;
    private Token token;

    public Lexer(IReader reader) {
        this.reader = reader;
    }

    private void analyse() throws ReaderException {

        while (lexemes.contains("")) {
            lexemes.remove("");
        }

        while (reader.hasChars() & flag == 1) {
            Character symbol = reader.readChars();

            if (!lexemes.isEmpty()) {
                flag = 0;
            }

            if (Character.isLetterOrDigit(symbol)) {
                lexeme.append(symbol);
            } else {
                lexemes.add(String.valueOf(lexeme));
                lexemes.add(String.valueOf(symbol));
                lexeme = new StringBuilder();
            }
        }
    }

    private Token determineToken() {
        switch (firstTokenStr) {
            case (";"):
                return Token.SEMICOLON;
            case ("{"):
            case ("}"):
                return Token.BRACKET;
            case (" "):
                return Token.SPACE;
        }
        return Token.OTHERS;
    }

    @Override
    public boolean hasMoreTokens() throws ReaderException {
        return reader.hasChars() | !lexemes.isEmpty();
    }

    @Override
    public IToken readToken() throws ReaderException {

        analyse();
        firstTokenStr = lexemes.poll();
        if (firstTokenStr != null) {
            token = determineToken();
        }
        readedToken = new TokenImpl(String.valueOf(token), firstTokenStr);
        firstTokenStr = secondTokenStr;
        secondTokenStr = null;

        if (firstTokenStr == null) {
            flag = 1;
        }
        return readedToken;
    }
}
