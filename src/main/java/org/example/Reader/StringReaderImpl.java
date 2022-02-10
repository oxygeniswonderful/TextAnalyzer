package org.example.Reader;

public class StringReaderImpl implements IReader {

    private String string;

    public StringReaderImpl(String string) {
        this.string = string;
    }

    @Override
    public boolean hasChars() {
        return !string.isEmpty();
    }

    @Override
    public char readChar() {
        char symbol = string.toCharArray()[0];
        string = string.substring(1);
        return symbol;
    }
}
