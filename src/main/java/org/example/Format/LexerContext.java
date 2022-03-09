package org.example.Format;

import org.example.Token.IToken;
import org.example.Token.TokenImpl;
import org.example.Writer.IWriter;
import org.example.Writer.WriterException;

public class LexerContext {
    private String tokenName;
    private StringBuilder tokenLexeme;
    private StringBuilder buffer;
    private IToken token;
    private IWriter writer;
    private String latestElement;
    private String indent;
    private int count;
    private int flag;
    private int isComment;

    public void setLatestElement(String latestElement) {
        this.latestElement = latestElement;
    }

    public void setIndent(String indent) {
        this.indent = indent;
    }

    public void setCount(int count) {
        this.count += count;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setIsComment(int isComment) {
        this.isComment = isComment;
    }

    public LexerContext(IWriter writer) {
        this.tokenName = "";
        this.tokenLexeme = new StringBuilder();
        this.buffer = new StringBuilder();
        this.writer = writer;
        this.latestElement = "";
        this.indent = "";
        this.count = 0;
        this.flag = 0;
        this.isComment = 0;
    }

    public String getLatestElement() {
        return latestElement;
    }

    public String getLatestIndent() {
        return indent;
    }

    public int getCountOfIndent() {
        return count;
    }

    public int getFlagOfMultiComment() {
        return flag;
    }

    public int getIsComment() {
        return isComment;
    }

    public void WriteLexeme(String lexemeToWrite) {
        try {
            writer.writeChar(lexemeToWrite);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public String getTokenName() {
        return tokenName;
    }

    public StringBuilder getTokenLexeme() {
        return tokenLexeme;
    }

    public void clean() {
        tokenLexeme = new StringBuilder();
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public void append(char symbol) {
        tokenLexeme.append(symbol);
    }

    public void appendToBuffer(char symbol) {
        buffer.append(symbol);
    }

    public void cleanBuffer() {
        buffer = new StringBuilder();
    }

    public StringBuilder getBuffer(){
        return buffer;
    }

    public void setToken(String tokenName, StringBuilder tokenLexeme) {
        token = new TokenImpl(tokenName, tokenLexeme.toString());
    }

    @Override
    public String toString() {
        return "LexerContext{" +
                "tokenName='" + tokenName + '\'' +
                ", tokenLexeme=" + tokenLexeme +
                '}';
    }
}
