package org.example;

import org.example.Format.Formatter;
import org.example.Format.IFormatter;
import org.example.Format.ILexer;
import org.example.Format.Lexer;
import org.example.Format.Lexer_v1;
import org.example.Reader.ReaderException;
import org.example.Reader.StringReaderImpl;
import org.example.Writer.StringWriterImpl;
import org.example.Writer.WriterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FormatterTest {

     @Test
    void format() throws WriterException, ReaderException {

         String string6 = "/* for i in range(10): ";
         String expected6 = "/* for i in range(10): ";
         init(string6, expected6);

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

        String string5 = "// for(int i = 0; i <= 10; i++) {";
        String expected5 = "// for(int i = 0; i <= 10; i++) {";
        init(string5, expected5);


    }
    void init(String string, String expected) throws WriterException, ReaderException {
        StringReaderImpl stringReader = new StringReaderImpl(string);
        StringBuilder stringBuilder = new StringBuilder();
        StringWriterImpl stringWriter = new StringWriterImpl(stringBuilder);
        ILexer lexer = new Lexer(stringReader, stringWriter);
        lexer.readToken();
        //System.out.println(stringBuilder.toString());
        assertEquals(stringBuilder.toString(), expected);
    }
}
