package org.example.Command_for_Formatter;

import org.example.Format.FormatterContext;
import org.example.Token.IToken;

public class MultiLineCommentEnd implements ICommandFormatter{
    @Override
    public void execute(IToken token, FormatterContext formatterContext) {
        //System.out.println(token.getLexeme());
        //System.out.print(formatterContext.getIndent());
        formatterContext.WriteLexeme(token.getLexeme());
        formatterContext.WriteLexeme("\n");
        formatterContext.WriteLexeme(formatterContext.getIndent());
    }
}
