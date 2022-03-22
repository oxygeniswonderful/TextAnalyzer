package org.example.io.Writer;

public class StringWriterImpl implements IWriter {
    private StringBuilder string;

    public StringWriterImpl(StringBuilder string) {
        this.string = string;
    }

    @Override
    public void writeChar(String symbol) throws WriterException {
        string.append(symbol);
    }
}
