package org.example.Format;

import org.example.Writer.IWriter;
import org.example.Writer.WriterException;

public class FormatterContext {
    private IWriter writer;
    

    public String getIndent() {
        return indent.toString();
    }

    private int count;
    private StringBuilder indent;

    public FormatterContext(IWriter writer) {
        this.writer = writer;
        this.indent = new StringBuilder();
        this.count = 0;
    }

    public void setCount(int count) {
        this.count += count;
    }

    public String createIndent() {
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
