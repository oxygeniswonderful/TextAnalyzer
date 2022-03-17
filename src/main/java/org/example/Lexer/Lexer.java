package org.example.Lexer;

import org.example.Command_for_Lexer.CommandRepository;
import org.example.Command_for_Lexer.ICommand;
import org.example.Format.State;
import org.example.Reader.ReaderException;
import org.example.Reader.StringReaderImpl;
import org.example.Token.IToken;
import org.example.Token.TokenImpl;
import org.example.Reader.IReader;
import org.example.Writer.IWriter;

public class Lexer implements ILexer {
    private final IReader reader;
    private CommandRepository commandRepository;
    private StateTransitionsRepository stateTransitionsRepository;
    private LexerContext lexerContext;

    public Lexer(IReader reader, IWriter writer) {
        this.reader = reader;
        this.lexerContext = new LexerContext(writer);
        commandRepository = new CommandRepository();
        stateTransitionsRepository = new StateTransitionsRepository();
    }

    @Override
    public boolean hasMoreTokens() throws ReaderException {
        return reader.hasChars();
    }

    public IToken readToken() throws ReaderException {

        State state = new State("initial");
        lexerContext.clean();

        IReader bufferReader = new StringReaderImpl(lexerContext.getBuffer().toString());
        while (bufferReader.hasChars() && state != null) {
            state = stateMachineStep(bufferReader, state, lexerContext);
        }

        lexerContext.cleanBuffer();

        while (reader.hasChars() && state != null) {
            state = stateMachineStep(reader, state, lexerContext);
        }

        System.out.println(lexerContext.getTokenLexeme().toString() + " LEXER");
        return new TokenImpl(lexerContext.getTokenName(), lexerContext.getTokenLexeme().toString());
    }

    public State stateMachineStep(IReader reader, State state, LexerContext lexerContext) throws ReaderException {
        char symbol = reader.readChars();
        ICommand command = commandRepository.getCommand(state, symbol);
        command.execute(symbol, lexerContext);
        return stateTransitionsRepository.getNextState(state, symbol);
    }
}