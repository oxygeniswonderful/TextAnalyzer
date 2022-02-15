package org.example;

import org.example.Reader.ReaderException;

public interface ILexer {
    boolean hasMoreTokens();
    String readToken() throws ReaderException;
}
