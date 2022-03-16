package org.example.Command_for_Formatter;

import org.example.Format.FormatterContext;
import org.example.Token.IToken;

public class Comment implements ICommandFormatter{
    @Override
    public void execute(IToken token, FormatterContext formatterContext) {
        formatterContext.setIsComment(1);
        formatterContext.WriteLexeme(token.getLexeme());
        System.out.println(token.getLexeme());
    }
}
