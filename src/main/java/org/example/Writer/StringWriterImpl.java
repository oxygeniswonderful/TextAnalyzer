package org.example.Writer;

public class StringWriterImpl implements IWriter {

    private StringBuilder string;

    public StringWriterImpl(StringBuilder string) {
        this.string = string;
    }

    @Override
    public void writeChar(String symbol) {
        string.append(symbol);
    }
}
