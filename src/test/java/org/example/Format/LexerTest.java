package org.example.Format;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.Lexer.ILexer;
import org.example.Lexer.Lexer;
import org.example.io.Reader.IReader;
import org.example.io.Reader.ReaderException;
import org.example.io.Reader.StringReaderImpl;
import org.example.Token.IToken;
import org.junit.jupiter.api.Test;

class LexerTest {
    private IReader reader;
    private ILexer lexer;

    @Test
    void testLexer() throws ReaderException {
        reader = new StringReaderImpl("   abc; //\n");
        lexer = new Lexer(reader);

        IToken token = lexer.readToken();
        assertEquals("   ", token.getLexeme());
        assertEquals("spaces", token.getName());

        token = lexer.readToken();
        assertEquals("a", token.getLexeme());
        assertEquals("char", token.getName());

        token = lexer.readToken();
        assertEquals("b", token.getLexeme());
        assertEquals("char", token.getName());

        token = lexer.readToken();
        assertEquals("c", token.getLexeme());
        assertEquals("char", token.getName());

        token = lexer.readToken();
        assertEquals(";", token.getLexeme());
        assertEquals("semicolon", token.getName());

        token = lexer.readToken();
        assertEquals(" ", token.getLexeme());
        assertEquals("space", token.getName());

        token = lexer.readToken();
        assertEquals("//", token.getLexeme());
        assertEquals("onelinecomment", token.getName());

        token = lexer.readToken();
        assertEquals("\n", token.getLexeme());
        assertEquals("newline", token.getName());
    }
}