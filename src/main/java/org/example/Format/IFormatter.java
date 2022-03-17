package org.example.Format;

import org.example.Lexer.ILexer;
import org.example.Reader.ReaderException;
import org.example.Writer.IWriter;
import org.example.Writer.WriterException;

public interface IFormatter {

    void format(ILexer lexer, IWriter writer) throws ReaderException, WriterException;
}
