package org.example;

import org.example.Reader.ReaderException;

public interface ILexer {
    boolean hasMoreTokens();
    IToken readToken() throws ReaderException;
}
