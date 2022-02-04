package org.example.Reader;

public class StringReaderImpl implements IReader {
    private String string;

    public StringReaderImpl(String string) {
        this.string = string;
    }

    @Override
    public boolean hasChars() throws ReaderException {
        return !string.isEmpty();
    }

    @Override
    public char readChars() throws ReaderException {
        char symbol = string.toCharArray()[0];
        string = string.substring(1);
        return symbol;
    }
}
