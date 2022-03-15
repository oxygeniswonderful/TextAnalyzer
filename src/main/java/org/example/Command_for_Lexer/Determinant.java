package org.example.Command_for_Lexer;

import org.example.Lexer.LexerContext;
import org.example.Format.Tools;

public class Determinant {

    LexerContext lexerContext;
    public Determinant(LexerContext lexerContext) {
        this.lexerContext = lexerContext;
    }
    public String determineTokenName() {

        String determinant = String.valueOf(lexerContext.getTokenLexeme());
        switch (determinant) {

            case ("/*"):
            case ("*/"):
                return "MULTI_LINE";

            case (" "):
                return "SPACE";

            case (";"):
                return "SEMICOLON";

            case ("{"):
            case ("}"):
                return "BRACKET";

            case ("\n"):
                return "LINE BREAK";
        }
        if (Tools.isDigitOrLetterForString(determinant)) {
            return "LeterOrDigit";
        }
        return "OTHER";
    }
}
