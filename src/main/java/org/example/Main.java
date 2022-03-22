package org.example;

import org.example.Format.Formatter;
import org.example.Format.IFormatter;
import org.example.Lexer.Lexer;
import org.example.io.Reader.FileReaderImpl;
import org.example.io.Reader.ReaderException;
import org.example.io.Writer.FileWriterImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final String PATH_OF_SOURCE = "/Users/admin/Desktop/text.txt";
    private static final String PATH_OF_ANSWER = "/Users/admin/Desktop/answer.txt";

    public static void main(String[] args) throws Exception {

        try (
                FileReaderImpl fileReader = new FileReaderImpl(new BufferedReader(new FileReader(PATH_OF_SOURCE, StandardCharsets.UTF_8)));
                FileWriterImpl fileWriter = new FileWriterImpl(new BufferedWriter(new FileWriter(PATH_OF_ANSWER, StandardCharsets.UTF_8)));
        ) {

            Lexer lexer = new Lexer(fileReader);
            IFormatter formatter = new Formatter(lexer, fileWriter);
            formatter.format(lexer, fileWriter);

        } catch (ReaderException e) {
            logger.error("Exception while read/write file: {}", e.toString());
        }
    }
}
