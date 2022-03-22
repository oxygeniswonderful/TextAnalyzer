package org.example.Lexer;

import org.example.Format.State;
import org.example.Lexer.commands.ICommand;
import org.example.io.Reader.ReaderException;
import org.example.io.Reader.StringReaderImpl;
import org.example.Token.IToken;
import org.example.Token.TokenImpl;
import org.example.io.Reader.IReader;

public class Lexer implements ILexer {
    private final IReader reader;
    private CommandRepository commandRepository;
    private StateTransitionsRepository stateTransitionsRepository;
    private LexerContext lexerContext;

    public Lexer(IReader reader) {
        this.reader = reader;
        this.lexerContext = new LexerContext();
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

        System.out.println(lexerContext.getTokenLexeme().toString() + " " + lexerContext.getTokenName() + " LEXER");
        return new TokenImpl(lexerContext.getTokenName(), lexerContext.getTokenLexeme().toString());
    }

    public State stateMachineStep(IReader reader, State state, LexerContext lexerContext) throws ReaderException {
        char symbol = reader.readChars();
        ICommand command = commandRepository.getCommand(state, symbol);
        command.execute(symbol, lexerContext);
        return stateTransitionsRepository.getNextState(state, symbol);
    }
}
