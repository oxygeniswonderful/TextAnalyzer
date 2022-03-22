package org.example.io.Reader;

public class StringReaderImpl implements IReader {
    private final String string;
    private int count = 0;

    public StringReaderImpl(String string) {
        this.string = string;
    }

    @Override
    public boolean hasChars() {
        return count < string.length();
    }

    @Override
    public char readChars() throws ReaderException {
        try {
            return string.charAt(count++);
        } catch (IndexOutOfBoundsException e) {
            throw new ReaderException("Char at " + count + " can not be read", e);
        }
    }
}
