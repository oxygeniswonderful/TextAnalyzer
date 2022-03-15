package org.example.Command_for_Formatter;

import org.example.Format.FormatterContext;
import org.example.Token.IToken;

public interface ICommandFormatter {
    void execute(IToken token, FormatterContext formatterContext);
}
