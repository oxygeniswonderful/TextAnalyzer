package org.example.Format;

import org.example.Reader.ReaderException;
import org.example.Writer.WriterException;

public interface IFormatter {
//void format() throws ReaderException, WriterException;

    void format(IToken token) throws ReaderException, WriterException;
}
