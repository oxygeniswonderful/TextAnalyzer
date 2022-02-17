package org.example.Format;

import org.example.Reader.ReaderException;
import org.example.Token.IToken;

public interface ILexer {

    boolean hasMoreTokens() throws ReaderException;

    IToken readToken() throws ReaderException;
}
