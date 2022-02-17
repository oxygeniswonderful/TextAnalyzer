package org.example.Format;
import org.example.Token.IToken;
import org.example.Reader.ReaderException;
import org.example.Writer.IWriter;
import org.example.Writer.WriterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Formatter implements IFormatter{
    private static final Logger logger = LoggerFactory.getLogger(Formatter.class);
    ILexer lexer;
    IWriter writer;

    public Formatter(ILexer lexer, IWriter writer) {
        this.lexer = lexer;
        this.writer = writer;
    }

    @Override
    public void format() throws ReaderException, WriterException {

        IToken token;
        String indent = "";
        String latestElement = "";
        int count = 0;
        int flag = 0;

        while (lexer.hasMoreTokens()) {
            token = lexer.readToken();

            if (token.getLexeme() == null) {
                continue;
            }

            if (token.getLexeme().equals("\u0000")) {
                continue;
            }

            if (token.getLexeme().equals(" ") & (latestElement.equals(" ") | (latestElement.equals("")))) {
                continue;
            }

            if (Tools.isOrdinarySymbol(latestElement) & token.getLexeme().equals(" ") & flag == 0) {
                continue;
            }

            if (latestElement.equals("/") & token.getLexeme().equals("*")) {
                flag = 1;
            }

            if (latestElement.equals("*") & token.getLexeme().equals("/")) {
                logger.debug(token.getLexeme() + "\n");
                logger.debug(indent);
                writer.writeChar(token.getLexeme());
                writer.writeChar("\n");
                writer.writeChar(indent);
                flag = 0;
                continue;
            }

            if (Tools.isShift(token.getLexeme())) {
                writer.writeChar(token.getLexeme());
                writer.writeChar(indent);
                logger.debug(token.getLexeme());
                logger.debug(indent);
            }

            if (Tools.isLeftBrace(token.getLexeme()) & !latestElement.equals(" ") & flag == 0) {
                writer.writeChar(" ");
                logger.debug(" ");
            }

            if (Tools.isSemicolon(latestElement) & !Tools.isRightBrace(token.getLexeme()) & flag == 0) {
                writer.writeChar(indent);
                logger.debug(indent);
            }

            if(Tools.isRightBrace(latestElement) & !Tools.isOrdinarySymbol(token.getLexeme()) & flag == 0) {
                writer.writeChar(indent);
                logger.debug(indent);
            }

            if (!Tools.isOrdinarySymbol(token.getLexeme())) {
                writer.writeChar(token.getLexeme());
                logger.debug(token.getLexeme());
            }

            if (Tools.isLeftBrace(token.getLexeme()) & flag == 0) {
                count += 4;
                indent = Tools.createIndent(count);
                writer.writeChar(token.getLexeme());
                writer.writeChar("\n");
                logger.debug(token.getLexeme() + "\n");
                writer.writeChar(indent);
                logger.debug(indent);
            }

            if ((Tools.isLeftBrace(token.getLexeme()) | Tools.isRightBrace(token.getLexeme()) | Tools.isSemicolon(token.getLexeme())) & flag == 1) {
                writer.writeChar(token.getLexeme());
                logger.debug(token.getLexeme());
            }

            if (Tools.isRightBrace(token.getLexeme()) & flag == 0) {
                count -= 4;
                indent = Tools.createIndent(count);
                writer.writeChar(indent);
                writer.writeChar(token.getLexeme());
                logger.debug(indent);
                logger.debug(token.getLexeme() + "\n");
                writer.writeChar("\n");

            }

            if (Tools.isSemicolon(token.getLexeme()) & flag == 0) {
                writer.writeChar(token.getLexeme());
                logger.debug(token.getLexeme() + "\n");
                writer.writeChar("\n");
            }
            latestElement = token.getLexeme();
        }
    }
}
