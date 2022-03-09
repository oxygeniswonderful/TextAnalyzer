package org.example.Format;

import org.example.Command.CommandRepository;
import org.example.Command.ICommand;
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

        while (reader.hasChars() && state != null) {
            state =  stateMachineStep(reader, state, lexerContext);
            if (state.getState().equals("END")) {
                IReader readerFromBuffer = new StringReaderImpl(lexerContext.getBuffer().toString());
                state = new State("initial");
                if (readerFromBuffer.hasChars()) {
                    state = stateMachineStep(readerFromBuffer, state, lexerContext);
                }
                if (state.getState().equals("END")) {
                    state = new State("initial");
                    lexerContext.cleanBuffer();
                    lexerContext.clean();
                }
            }
        }
        TokenImpl t = new TokenImpl(lexerContext.getTokenName(), lexerContext.getTokenLexeme().toString());
        System.out.println(lexerContext.getTokenLexeme().toString() + " " + lexerContext.getTokenName());
        return t;
    }

    public State stateMachineStep(IReader reader, State state, LexerContext lexerContext) throws ReaderException {
        char symbol = reader.readChars();
        ICommand command = commandRepository.getCommand(state, symbol);
        command.execute(symbol, lexerContext);
        return stateTransitionsRepository.getNextState(state, symbol);
    }
}
