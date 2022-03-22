package org.example.Format.commands;

import org.example.Format.FormatterContext;
import org.example.Token.IToken;

public class RightBracket implements ICommandFormatter{
    @Override
    public void execute(IToken token, FormatterContext formatterContext) {
        formatterContext.setCount(-4);
        formatterContext.createIndent();
        formatterContext.WriteLexeme(formatterContext.getIndent());
        formatterContext.WriteLexeme(token.getLexeme());
        formatterContext.WriteLexeme("\n");
        //System.out.println(formatterContext.getIndent());
        //System.out.println(token.getLexeme());
    }
}
