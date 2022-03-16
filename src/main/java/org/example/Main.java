package org.example;

import org.example.Format.Formatter;
import org.example.Format.IFormatter;
import org.example.Format.ILexer;
import org.example.Format.Lexer;
import org.example.Reader.FileReaderImpl;
import org.example.Reader.ReaderException;
import org.example.Writer.FileWriterImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) throws Exception {

        try (
                FileReaderImpl fileReader = new FileReaderImpl(new BufferedReader(new FileReader(args[0], StandardCharsets.UTF_8)));
                FileWriterImpl fileWriter = new FileWriterImpl(new BufferedWriter(new FileWriter(args[1], StandardCharsets.UTF_8)));
        ) {

            Lexer lexer = new Lexer(fileReader, fileWriter);
            IFormatter formatter = new Formatter(lexer, fileWriter);
            formatter.format(lexer, fileWriter);

        } catch (ReaderException e) {
            logger.error("Exception while read/write file: {}", e.toString());
        }
    }
}
