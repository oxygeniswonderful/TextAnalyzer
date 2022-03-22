package org.example.io.Reader;

public class ReaderException extends Exception {

    public ReaderException(String message) {
        super(message);
    }

    public ReaderException(String message, Throwable e) {
        super(message, e);
    }
}
