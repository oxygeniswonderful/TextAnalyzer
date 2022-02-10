package org.example.Format;

import org.example.Reader.IReader;
import org.example.Reader.ReaderException;

import java.util.ArrayDeque;
import java.util.Queue;

public class Lexer {

    private final IReader reader;

    public Lexer(IReader reader) {
        this.reader = reader;
    }

    public Queue<String> analyse() throws ReaderException {

        Queue<String> lexemes = new ArrayDeque<>();
        StringBuilder lexeme = new StringBuilder();

        while(reader.hasChars()) {
            Character symbol = reader.readChar();
            if (Character.isLetterOrDigit(symbol)) {
                lexeme.append(symbol);
            } else {
                lexemes.add(String.valueOf(lexeme));
                lexemes.add(String.valueOf(symbol));
                lexeme = new StringBuilder();
            }
        }
        while (lexemes.contains("")) {
            lexemes.remove("");
        }
        return lexemes;
    }
}
