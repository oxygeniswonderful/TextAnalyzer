package org.example.Format;

import org.example.Reader.ReaderException;
import org.example.Token.TokenImpl;
import org.example.Writer.WriterException;

public class TokenBuilder {

    public TokenImpl buildToken(LexerContext lexerContext, boolean flag, char symbol) {
        String tokenName = lexerContext.getTokenName();
        StringBuilder tokenLexeme = lexerContext.getTokenLexeme();
        //Q<IToken> q = new Q<>();
        //PutToQThread putToQThread = new PutToQThread<>(q, new TokenImpl(tokenName, tokenLexeme.toString()));
        //DeleteFromQThread<IToken> deleteFromQThread = new DeleteFromQThread<>(q);
        //putToQThread.run();
        //deleteFromQThread.run();
        System.out.println(lexerContext);
        //lexerContext.WriteLexeme(lexerContext.getTokenLexeme());
        IFormatter formatter = new Formatter(lexerContext);
        try {
            formatter.format(new TokenImpl(tokenName, tokenLexeme.toString()));
        } catch (ReaderException e) {
            e.printStackTrace();
        } catch (WriterException e) {
            e.printStackTrace();
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
