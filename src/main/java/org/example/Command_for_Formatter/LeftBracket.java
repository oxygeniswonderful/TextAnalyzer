package org.example.Command_for_Formatter;

import org.example.Format.FormatterContext;
import org.example.Token.IToken;

public class LeftBracket implements ICommandFormatter{
    @Override
    public void execute(IToken token, FormatterContext formatterContext) {

        formatterContext.setCount(4);
        formatterContext.createIndent();
        formatterContext.WriteLexeme(token.getLexeme());
        formatterContext.WriteLexeme("\n");
        formatterContext.WriteLexeme(formatterContext.getIndent());
        //System.out.println(token.getLexeme());
        //System.out.println(formatterContext.getIndent());
    }
}
