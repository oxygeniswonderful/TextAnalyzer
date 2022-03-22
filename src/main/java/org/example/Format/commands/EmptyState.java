package org.example.Format.commands;

import org.example.Format.FormatterContext;
import org.example.Token.IToken;

public class EmptyState implements ICommandFormatter{
    @Override
    public void execute(IToken token, FormatterContext formatterContext) {

    }
}
