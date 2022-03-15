package org.example.Lexer;

import org.example.Token.IToken;
import org.example.Reader.ReaderException;

public interface ILexer {
    boolean hasMoreTokens() throws ReaderException;
    IToken readToken() throws ReaderException;
}
