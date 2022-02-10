package org.example;


import org.example.Reader.ReaderException;
import org.example.Writer.WriterException;

public interface IFormatter {
    void format() throws ReaderException, WriterException;
}
