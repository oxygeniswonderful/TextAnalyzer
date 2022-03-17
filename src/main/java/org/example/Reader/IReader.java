package org.example.Reader;

public interface IReader {
    boolean hasChars() throws ReaderException;
    char readChars() throws ReaderException;
}
