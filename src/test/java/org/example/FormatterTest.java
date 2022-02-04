package org.example;

import org.example.Reader.ReaderException;
import org.example.Reader.StringReaderImpl;
import org.example.Writer.StringWriterImpl;
import org.example.Writer.WriterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FormatterTest {

    @Test
    void format() throws WriterException, ReaderException {
        String string = "    if (flex == rofl + chill ) { return KEK; }";
        String expected = "if (flex == rofl + chill ) {\n" +
                "    return KEK;\n" +
                "}\n";
        StringReaderImpl stringReader = new StringReaderImpl(string);
        StringBuilder stringBuilder = new StringBuilder();
        StringWriterImpl stringWriter = new StringWriterImpl(stringBuilder);
        Formatter formatter = new Formatter(stringReader, stringWriter);
        formatter.format();
        assertEquals(stringBuilder.toString(), expected);
    }
}