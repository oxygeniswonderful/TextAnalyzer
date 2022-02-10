package org.example;

import org.example.Format.Formatter;
import org.example.Reader.FileReaderImpl;
import org.example.Reader.ReaderException;
import org.example.Writer.FileWriterImpl;
import org.example.Writer.WriterException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    private static final String PATH_OF_SOURCE = "/text.txt";
    private static final String PATH_OF_ANSWER = "/answer.txt";

    public static void main(String[] args) throws Exception {

        try (
            FileReaderImpl fileReader = new FileReaderImpl(new BufferedReader(new FileReader(PATH_OF_SOURCE)));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_OF_ANSWER));
            FileWriterImpl fileWriter = new FileWriterImpl(bufferedWriter);
        ) {
            Formatter formatter = new Formatter(fileReader, fileWriter);
            formatter.format();
        } catch (ReaderException | WriterException e) {
            System.err.println("Exception while read/write file: " + e);
        }
    }
}
