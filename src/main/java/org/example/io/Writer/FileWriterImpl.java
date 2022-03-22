package org.example.io.Writer;

import org.example.AutoClose.AutoCloseException;
import org.example.AutoClose.IAutoClose;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements IWriter, IAutoClose {
    private final BufferedWriter bufferedWriter;
    private static final Logger logger = LoggerFactory.getLogger(FileWriterImpl.class);

    public FileWriterImpl(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void writeChar(String symbol) throws WriterException {
        try {
            bufferedWriter.write(symbol);
        } catch (IOException e) {
            logger.error("Can't write symbol " + symbol +" in file" + e);
            throw new WriterException("Can't write symbol " + symbol +" in file");
        }
    }

    @Override
    public void close() throws AutoCloseException {
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                logger.error("Can't close the file" + e);
                throw new AutoCloseException("Can't close the file");
            }
        }
    }
}
