package org.example.Reader;
import org.example.IAutoClose;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReaderImpl implements IReader, IAutoClose {
    private final BufferedReader bufferedReader;

    public FileReaderImpl(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
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

    @Override
    public boolean hasChars() throws ReaderException {
        try {
            return bufferedReader.ready();
        } catch (IOException e) {
            throw new ReaderException("Can't read the file");
        }
    }

    @Override
    public char readChars() throws ReaderException {
        try {
            return (char) bufferedReader.read();
        } catch (IOException e) {
            throw new ReaderException(" Can't read symbol from the file");
        }
    }
}
