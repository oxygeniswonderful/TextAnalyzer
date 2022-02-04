package org.example;

import org.example.Reader.IReader;
import org.example.Reader.ReaderException;
import org.example.Writer.IWriter;
import org.example.Writer.WriterException;

public class Formatter {

    IReader reader;
    IWriter writer;

    public Formatter(IReader reader, IWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void format() throws ReaderException, WriterException {
        Character symbol;
        String indent = "";
        Character latestElement = '0';
        int count = 0;

        while (reader.hasChars()) {
            symbol = reader.readChars();

            if (symbol.equals(' ') & (latestElement.equals(' ') | (latestElement.equals('0')))) {
                continue;
            }

            if (Tools.isOrdinarySymbol(latestElement) & symbol.equals(' ')) {
                continue;
            }

            if (Tools.isLeftBrace(symbol) & !latestElement.equals(' ')) {
                writer.writeChar(" ");
            }

            if (Tools.isSemicolon(latestElement) & !Tools.isRightBrace(symbol)) {
                writer.writeChar(indent);
            }

            if(Tools.isRightBrace(latestElement) & !Tools.isOrdinarySymbol(symbol)) {
                writer.writeChar(indent);
            }

            if (!Tools.isOrdinarySymbol(symbol)) {
                writer.writeChar(symbol.toString());
            }

            if (Tools.isLeftBrace(symbol)) {
                count += 4;
                indent = Tools.createIndent(count);
                writer.writeChar(symbol.toString());
                writer.writeChar("\n");
                writer.writeChar(indent);
            }

            if (Tools.isRightBrace(symbol)) {
                count -= 4;
                indent = Tools.createIndent(count);
                writer.writeChar(indent);
                writer.writeChar(symbol.toString());
                writer.writeChar("\n");
            }

            if (Tools.isSemicolon(symbol)) {
                writer.writeChar(symbol.toString());
                writer.writeChar("\n");
            }
            latestElement = symbol;
        }
    }
}
