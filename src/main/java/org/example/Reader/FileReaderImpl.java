package org.example.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import org.example.AutoClose.AutoCloseException;
import org.example.AutoClose.IAutoClose;

public class FileReaderImpl implements IReader, IAutoClose {

    private final BufferedReader bufferedReader;
    private int readedSymbol;

    public FileReaderImpl(BufferedReader bufferedReader) throws ReaderException {
        this.bufferedReader = bufferedReader;
        readedSymbol = readSymbol();
    }

    @Override
    public boolean hasChars() {
        return readedSymbol != -1;
    }

    @Override
    public char readChar() throws ReaderException {
        char readedChar = (char) readedSymbol;
        readedSymbol = readSymbol();
        return readedChar;
    }

    @Override
    public void close() throws AutoCloseException {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new AutoCloseException("Can't close the file");
            }
        }
    }

    private int readSymbol() throws ReaderException {
        try {
            return bufferedReader.read();
        } catch (IOException e) {
            throw new ReaderException(" Can't read symbol from the file");
        }
    }
}
