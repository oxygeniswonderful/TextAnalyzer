package org.example.Format;
import org.example.Reader.IReader;
import org.example.Reader.ReaderException;
import org.example.Writer.IWriter;
import org.example.Writer.WriterException;
import java.util.Queue;

public class Formatter implements IFormatter{

    IReader reader;
    IWriter writer;


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
        int flag = 0;


        while (!lexemes.isEmpty()) {

            symbol = lexemes.poll();

            if (symbol.equals(" ") & (latestElement.equals(" ") | (latestElement.equals("")))) {
                continue;
            }

            if (Tools.isOrdinarySymbol(latestElement) & symbol.equals(" ") & flag == 0) {
                continue;
            }

            if (latestElement.equals("/") & symbol.equals("*")) {
                flag = 1;
            }

            if (latestElement.equals("*") & symbol.equals("/")) {
                writer.writeChar(symbol);
                writer.writeChar("\n");
                writer.writeChar(indent);
                flag = 0;
                continue;
            }

            if (Tools.isShift(symbol)) {
                writer.writeChar(symbol);
                writer.writeChar(indent);
            }

            if (Tools.isLeftBrace(symbol) & !latestElement.equals(" ") & flag == 0) {
                writer.writeChar(" ");
            }

            if (Tools.isSemicolon(latestElement) & !Tools.isRightBrace(symbol) & flag == 0) {
                writer.writeChar(indent);
            }

            if(Tools.isRightBrace(latestElement) & !Tools.isOrdinarySymbol(symbol) & flag == 0) {
                writer.writeChar(indent);
            }

            if (!Tools.isOrdinarySymbol(symbol)) {
                writer.writeChar(symbol);
            }

            if (Tools.isLeftBrace(symbol) & flag == 0) {
                count += 4;
                indent = Tools.createIndent(count);
                writer.writeChar(symbol);
                writer.writeChar("\n");
                writer.writeChar(indent);
               
            }

            if ((Tools.isLeftBrace(symbol) | Tools.isRightBrace(symbol) | Tools.isSemicolon(symbol)) & flag == 1) {
                writer.writeChar(symbol);
            }

            if (Tools.isRightBrace(symbol) & flag == 0) {
                count -= 4;
                indent = Tools.createIndent(count);
                writer.writeChar(indent);
                writer.writeChar(symbol);
                writer.writeChar("\n");

            }

            if (Tools.isSemicolon(symbol) & flag == 0) {
                writer.writeChar(symbol);
                writer.writeChar("\n");
            }
            latestElement = symbol;
        }
    }
}
