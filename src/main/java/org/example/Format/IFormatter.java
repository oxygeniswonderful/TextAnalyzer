package org.example.Format;

import org.example.Lexer.ILexer;
import org.example.io.Reader.ReaderException;
import org.example.io.Writer.IWriter;
import org.example.io.Writer.WriterException;

public interface IFormatter {

    void format(ILexer lexer, IWriter writer) throws ReaderException, WriterException;
}
