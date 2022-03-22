package org.example.Format.commands;

import org.example.Format.FormatterContext;
import org.example.Token.IToken;

public class LineBreak implements ICommandFormatter{
    @Override
    public void execute(IToken token, FormatterContext formatterContext) {

        System.out.print(token.getLexeme());
        formatterContext.WriteLexeme(token.getLexeme());
        formatterContext.WriteLexeme(formatterContext.getIndent());
        //System.out.print(formatterContext.getIndent());
    }
}
