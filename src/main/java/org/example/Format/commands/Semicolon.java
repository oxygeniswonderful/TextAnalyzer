package org.example.Format.commands;

import org.example.Format.FormatterContext;
import org.example.Token.IToken;

public class Semicolon implements ICommandFormatter{
    @Override
    public void execute(IToken token, FormatterContext formatterContext) {

        formatterContext.WriteLexeme(formatterContext.getIndent() + token.getLexeme());
        //System.out.println(formatterContext.getIndent() + token.getLexeme());
        formatterContext.WriteLexeme("\n");
    }
}
