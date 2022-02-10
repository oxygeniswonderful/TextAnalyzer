package org.example.Format;

import org.example.Reader.IReader;
import org.example.Reader.ReaderException;
import org.example.Writer.IWriter;
import org.example.Writer.WriterException;

import java.util.Queue;

public class Formatter implements IFormatter {

    private final IReader reader;
    private final IWriter writer;

    public Formatter(IReader reader, IWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void format() throws ReaderException, WriterException {
        Lexer lexer = new Lexer(reader);
        Queue<String> lexemes = lexer.analyse();
        String symbol;
        String indent = "";
        String latestElement = "";
        int count = 0;


        while (!lexemes.isEmpty()) {

            symbol = lexemes.poll();

            if (symbol.equals(" ") & (latestElement.equals(" ") | (latestElement.equals("")))) {
                continue;
            }

            if (Tools.isOrdinarySymbol(latestElement) & symbol.equals(" ")) {
                continue;
            }

            if (Tools.isLeftBrace(symbol) & !latestElement.equals(" ")) {
                writer.writeChar(" ");
                //System.out.print(" ");
            }

            if (Tools.isSemicolon(latestElement) & !Tools.isRightBrace(symbol)) {
                writer.writeChar(indent);
                //System.out.print(indent);
            }

            if(Tools.isRightBrace(latestElement) & !Tools.isOrdinarySymbol(symbol)) {
                writer.writeChar(indent);
                //System.out.print(indent);
            }

            if (!Tools.isOrdinarySymbol(symbol)) {
                writer.writeChar(symbol);
                //System.out.print(symbol);
            }

            if (Tools.isLeftBrace(symbol)) {
                count += 4;
                indent = Tools.createIndent(count);
                writer.writeChar(symbol);
                writer.writeChar("\n");
                //System.out.println(symbol);
                writer.writeChar(indent);
                //System.out.print(indent);
            }

            if (Tools.isRightBrace(symbol)) {
                count -= 4;
                indent = Tools.createIndent(count);
                writer.writeChar(indent);
                //System.out.print(indent);
                writer.writeChar(symbol);
                //System.out.println(symbol);
                writer.writeChar("\n");
            }

            if (Tools.isSemicolon(symbol)) {
                writer.writeChar(symbol);
                //System.out.println(symbol);
                writer.writeChar("\n");
            }
            latestElement = symbol;
        }
    }
}
