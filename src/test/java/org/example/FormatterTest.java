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
        init(string, expected);

        String string1 = ";";
        String expected1 = ";\n";
        init(string1, expected1);

        String string2 = "if(5!=2){";
        String expected2 = "if(5!=2) {\n    ";
        init(string2, expected2);

        String string3 = " {";
        String expected3 = " {\n    ";
        init(string3, expected3);

        String string4 = ";a";
        String expected4 = ";\n";
        init(string4, expected4);

    }
    void init(String string, String expected) throws WriterException, ReaderException {
        StringReaderImpl stringReader = new StringReaderImpl(string);
        StringBuilder stringBuilder = new StringBuilder();
        StringWriterImpl stringWriter = new StringWriterImpl(stringBuilder);
        Formatter formatter = new Formatter(stringReader, stringWriter);
        formatter.format();
        assertEquals(stringBuilder.toString(), expected);
    }
}
