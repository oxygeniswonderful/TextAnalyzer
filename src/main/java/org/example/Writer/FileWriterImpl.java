package org.example.Writer;

import org.example.AutoClose.AutoCloseException;
import org.example.AutoClose.IAutoClose;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements IWriter, IAutoClose {
    private final BufferedWriter bufferedWriter;

    public FileWriterImpl(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void writeChar(String symbol) throws WriterException {
        try {
            bufferedWriter.write(symbol);
        } catch (IOException e) {
            throw new WriterException("Can't write symbol " + symbol +" in file");
        }
    }

    @Override
    public void close() throws AutoCloseException {
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new AutoCloseException("Can't close the file");
            }
        }
    }
}
