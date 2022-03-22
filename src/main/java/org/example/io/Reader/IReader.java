package org.example.io.Reader;

public interface IReader {
    boolean hasChars() throws ReaderException;
    char readChars() throws ReaderException;
}
