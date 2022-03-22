package org.example.Command_for_Formatter;

import org.example.Format.FormatterContext;
import org.example.Token.IToken;

public class StandartState implements ICommandFormatter{
    @Override
    public void execute(IToken token, FormatterContext formatterContext) {
        formatterContext.WriteLexeme(token.getLexeme());
        //System.out.print(token.getLexeme());
    }
}
