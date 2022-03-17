package org.example.Lexer;

import org.example.Token.TokenImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenBuilder {
    private final Logger logger = LoggerFactory.getLogger(TokenBuilder.class);

    public TokenImpl buildToken(LexerContext lexerContext, boolean flag, char symbol) {
        String tokenName = lexerContext.getTokenName();
        StringBuilder tokenLexeme = lexerContext.getTokenLexeme();
        //IFormatter formatter = new Formatter(lexerContext);
        //try {
         //   formatter.format(new TokenImpl(tokenName, tokenLexeme.toString()));
        //} catch (ReaderException e) {
        //    logger.error(" Can't read symbol from the file" + e);
       // } catch (WriterException e) {
          //  logger.error("Can't close the file" + e);
        //}
        lexerContext.cleanBuffer();
        if (flag) {
            lexerContext.appendToBuffer(symbol);
        }
        //lexerContext.clean();
        lexerContext.setToken(tokenName, tokenLexeme);
        //System.out.println(tokenLexeme.toString() + " " + tokenName);
        return new TokenImpl(tokenName, tokenLexeme.toString());
    }
}
