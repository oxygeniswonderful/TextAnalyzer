package org.example.Format;

import org.example.Writer.IWriter;
import org.example.Writer.WriterException;

public class FormatterContext {
    private IWriter writer;
    private int count = 0;
    private String indent;


    public FormatterContext(IWriter writer) {
        this.writer = writer;
    }

    public void setCount(int count) {
        this.count += count;
    }

    public String createIndent() {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < count; i++)
            indent.append(" ");
        return indent.toString();
    }

    public void WriteLexeme(String lexemeToWrite) {
        try {
            writer.writeChar(lexemeToWrite);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
