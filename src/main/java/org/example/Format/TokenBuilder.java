package org.example.Format;

import org.example.Reader.ReaderException;
import org.example.Token.TokenImpl;
import org.example.Writer.WriterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenBuilder {
    private final Logger logger = LoggerFactory.getLogger(TokenBuilder.class);

    public TokenImpl buildToken(LexerContext lexerContext, boolean flag, char symbol) {
        String tokenName = lexerContext.getTokenName();
        StringBuilder tokenLexeme = lexerContext.getTokenLexeme();
        //Q<IToken> q = new Q<>();
        //PutToQThread putToQThread = new PutToQThread<>(q, new TokenImpl(tokenName, tokenLexeme.toString()));
        //DeleteFromQThread<IToken> deleteFromQThread = new DeleteFromQThread<>(q);
        //putToQThread.run();
        //deleteFromQThread.run();
        IFormatter formatter = new Formatter(lexerContext);
        try {
            formatter.format(new TokenImpl(tokenName, tokenLexeme.toString()));
        } catch (ReaderException e) {
            logger.error(" Can't read symbol from the file" + e);
        } catch (WriterException e) {
            logger.error("Can't write the symbol to the file" + e);
        }
        lexerContext.cleanBuffer();
        if (flag) {
            lexerContext.appendToBuffer(symbol);
        }
        lexerContext.clean();
        lexerContext.setToken(tokenName, tokenLexeme);
       return new TokenImpl(tokenName, tokenLexeme.toString());
    }
}
