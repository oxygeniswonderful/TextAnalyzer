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
    private LexerContext lexerContext;
    //Q<IToken> q;

    public Formatter(ILexer lexer, IWriter writer) {
        this.lexer = lexer;
        this.writer = writer;
        //q = new Q<IToken>();
    }
    public Formatter(LexerContext lexerContext) {
        this.lexerContext = lexerContext;
    }

    @Override
    public void format(IToken token) throws ReaderException, WriterException {

        //IToken token;
        //String latestElement = "";
        //String indent = "";
        //int count = 0;
        //int flag = 0;
        //int isComment = 0;
        //System.out.println(latestElement + " LATEST ELEMENT");
        //DeleteFromQThread<IToken> deleteFromQThread = new DeleteFromQThread<>(q);

        //while (lexer.hasMoreTokens()) {
            //lexer.readToken();
            //token = lexer.readToken();//deleteFromQThread.getElement();

            /* if (token.getLexeme() == null) {
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

            if (latestElement.equals("/") & token.getLexeme().equals("/")) {
                isComment = 1;
            }
            if (Tools.isShift(token.getLexeme()) & isComment == 1) {
                isComment = 0;
                System.out.print(token.getLexeme());
                writer.writeChar(token.getLexeme());
                writer.writeChar(indent);
                System.out.print(indent);
                logger.debug(token.getLexeme());
                logger.debug(indent);
            }
            if (latestElement.equals("/") & token.getLexeme().equals("*")) {
                flag = 1;
            }
            if (latestElement.equals("*") & token.getLexeme().equals("/")) {
                logger.debug(token.getLexeme() + "\n");
                logger.debug(indent);
                System.out.println(token.getLexeme());
                System.out.print(indent);
                writer.writeChar(token.getLexeme());
                writer.writeChar("\n");
                writer.writeChar(indent);
                flag = 0;
                continue;
            }
            if (Tools.isLeftBrace(token.getLexeme()) & !latestElement.equals(" ") & flag == 0) {
                //writer.writeChar(" ");
                lexerContext.WriteLexeme(" ");
                System.out.print(" ");
                logger.debug(" ");
            }
             */

        if (token.getName().equals("COMMENT")) {
            //isComment = 1;
            lexerContext.setIsComment(1);
        }

        if (token.getName().equals("LINE BREAK") & lexerContext.getIsComment() == 1) {
            //isComment = 0;
            lexerContext.setIsComment(0);
            System.out.print(token.getLexeme());
            //writer.writeChar(token.getLexeme());
            //writer.writeChar(indent);
            lexerContext.WriteLexeme(token.getLexeme());
            lexerContext.WriteLexeme(lexerContext.getLatestIndent());
            System.out.print(lexerContext.getLatestIndent());
            logger.debug(token.getLexeme());
            logger.debug(lexerContext.getLatestIndent());
        }

        if (token.getLexeme().equals("/*")) {
            lexerContext.setFlag(1);
        }

        if (token.getLexeme().equals("*/")) {
            logger.debug(token.getLexeme() + "\n");
            logger.debug(lexerContext.getLatestIndent());
            System.out.println(token.getLexeme());
            System.out.print(lexerContext.getLatestIndent());
            //writer.writeChar(token.getLexeme());
            //writer.writeChar("\n");
            //writer.writeChar(indent);
            lexerContext.WriteLexeme(token.getLexeme());
            lexerContext.WriteLexeme("\n");
            lexerContext.WriteLexeme(lexerContext.getLatestIndent());
            lexerContext.setFlag(0);
        }

        if (Tools.isLeftBrace(token.getLexeme()) & lexerContext.getFlagOfMultiComment() == 0 & !lexerContext.getLatestElement().equals(" ")) {
            //writer.writeChar(" ");
            lexerContext.WriteLexeme(" ");
            System.out.print(" ");
            logger.debug(" ");
        }

            if (Tools.isSemicolon(lexerContext.getLatestElement()) & !Tools.isRightBrace(token.getLexeme()) & lexerContext.getFlagOfMultiComment() == 0 & lexerContext.getIsComment() == 0) {
                //writer.writeChar(indent);
                lexerContext.WriteLexeme(lexerContext.getLatestIndent());
                System.out.print(lexerContext.getLatestIndent());
                logger.debug(lexerContext.getLatestIndent());
            }

            if(Tools.isRightBrace(lexerContext.getLatestElement()) & !Tools.isOrdinarySymbol(token.getLexeme()) & lexerContext.getFlagOfMultiComment() == 0 & lexerContext.getIsComment() == 0) {
                //writer.writeChar(indent);
                lexerContext.WriteLexeme(lexerContext.getLatestIndent());
                System.out.print(lexerContext.getLatestIndent());
                logger.debug(lexerContext.getLatestIndent());
            }

            if (!Tools.isOrdinarySymbol(token.getLexeme())) {
                //writer.writeChar(token.getLexeme());
                lexerContext.WriteLexeme(token.getLexeme());
                System.out.print(token.getLexeme());
                logger.debug(token.getLexeme());
            }

            if (Tools.isLeftBrace(token.getLexeme()) & lexerContext.getFlagOfMultiComment() == 0 & lexerContext.getIsComment() == 0) {
                //count += 4;
                lexerContext.setCount(4);
                //indent = Tools.createIndent(count);
                lexerContext.setIndent(Tools.createIndent(lexerContext.getCountOfIndent()));
                //writer.writeChar(token.getLexeme());
                //writer.writeChar("\n");
                lexerContext.WriteLexeme(token.getLexeme());
                lexerContext.WriteLexeme("\n");
                System.out.println(token.getLexeme());
                logger.debug(token.getLexeme() + "\n");
                System.out.println(lexerContext.getLatestIndent());
                //writer.writeChar(indent);
                lexerContext.WriteLexeme(lexerContext.getLatestIndent());
                System.out.print(lexerContext.getLatestIndent());
                logger.debug(lexerContext.getLatestIndent());
            }

            if ((Tools.isLeftBrace(token.getLexeme()) | Tools.isRightBrace(token.getLexeme()) | Tools.isSemicolon(token.getLexeme())) & lexerContext.getFlagOfMultiComment() == 1) {
                System.out.print(token.getLexeme());
                //writer.writeChar(token.getLexeme());
                lexerContext.WriteLexeme(token.getLexeme());
                logger.debug(token.getLexeme());
            }

            if ((Tools.isLeftBrace(token.getLexeme()) | Tools.isRightBrace(token.getLexeme()) | Tools.isSemicolon(token.getLexeme())) & lexerContext.getIsComment() == 1) {
                System.out.print(token.getLexeme());
                //writer.writeChar(token.getLexeme());
                lexerContext.WriteLexeme(token.getLexeme());
                logger.debug(token.getLexeme());
            }

            if (Tools.isRightBrace(token.getLexeme()) & lexerContext.getFlagOfMultiComment() == 0 & lexerContext.getIsComment() == 0) {
                //count -= 4;
                lexerContext.setCount(-4);
                //indent = Tools.createIndent(count);
                lexerContext.setIndent(Tools.createIndent(lexerContext.getCountOfIndent()));
                //writer.writeChar(indent);
                lexerContext.WriteLexeme(lexerContext.getLatestIndent());
                System.out.print(lexerContext.getLatestIndent());
                //writer.writeChar(token.getLexeme());
                lexerContext.WriteLexeme(token.getLexeme());
                System.out.println(token.getLexeme());
                logger.debug(lexerContext.getLatestIndent());
                logger.debug(token.getLexeme() + "\n");
                //writer.writeChar("\n");
                lexerContext.WriteLexeme("\n");

            }

            if (Tools.isSemicolon(token.getLexeme()) & lexerContext.getFlagOfMultiComment() == 0 & lexerContext.getIsComment() == 0) {
                //writer.writeChar(token.getLexeme());
                lexerContext.WriteLexeme(token.getLexeme());
                System.out.println(token.getLexeme());
                logger.debug(token.getLexeme() + "\n");
                //writer.writeChar("\n");
                lexerContext.WriteLexeme("\n");
            }
        lexerContext.setLatestElement(token.getLexeme());//token.getLexeme();
        //}
    }
}
