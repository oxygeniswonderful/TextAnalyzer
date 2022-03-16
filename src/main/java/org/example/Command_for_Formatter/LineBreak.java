package org.example.Command_for_Formatter;

import org.example.Format.FormatterContext;
import org.example.Token.IToken;

public class LineBreak implements ICommandFormatter{
    @Override
    public void execute(IToken token, FormatterContext formatterContext) {

        formatterContext.setIsComment(0);
        System.out.print(token.getLexeme());
        formatterContext.WriteLexeme(token.getLexeme());
        formatterContext.WriteLexeme(formatterContext.getIndent());
        System.out.print(formatterContext.getIndent());
    }
}
