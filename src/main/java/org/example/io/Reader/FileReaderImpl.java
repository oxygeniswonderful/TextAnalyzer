package org.example.io.Reader;
import org.example.AutoClose.AutoCloseException;
import org.example.AutoClose.IAutoClose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReaderImpl implements IReader, IAutoClose {
    private static final Logger logger = LoggerFactory.getLogger(FileReaderImpl.class);
    private final BufferedReader bufferedReader;
    private int readedSymbol;

    public FileReaderImpl(BufferedReader bufferedReader) throws ReaderException {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void close() throws AutoCloseException {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                logger.error("Can't close the file" + e);
                throw new AutoCloseException("Can't close the file");

            }
        }
    }

    @Override
    public boolean hasChars() {
        return readedSymbol != -1;
    }

    @Override
    public char readChars() throws ReaderException {
        char readedChar = (char) readedSymbol;
        readedSymbol = readSymbol();
        return readedChar;
    }

    private int readSymbol() throws ReaderException {
        try {
            return bufferedReader.read();
        } catch (IOException e) {
            logger.error(" Can't read symbol from the file" + e);
            throw new ReaderException(" Can't read symbol from the file");
        }
    }
}
