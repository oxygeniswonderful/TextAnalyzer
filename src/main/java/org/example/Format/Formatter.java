package org.example.Format;
import org.example.Format.commands.CommandRepositoryFormatter;
import org.example.Format.commands.ICommandFormatter;
import org.example.Lexer.ILexer;
import org.example.io.Reader.ReaderException;
import org.example.Token.IToken;
import org.example.io.Writer.IWriter;
import org.example.io.Writer.WriterException;


public class Formatter implements IFormatter{
    private CommandRepositoryFormatter commandRepositoryFormatter;
    private StateTransitionsRepositoryFormatter stateTransitionsRepositoryFormatter;
    private FormatterContext context;
    ILexer lexer;
    IWriter writer;

    public Formatter(ILexer lexer, IWriter writer) {
        this.lexer = lexer;
        this.writer = writer;
        commandRepositoryFormatter = new CommandRepositoryFormatter();
        stateTransitionsRepositoryFormatter = new StateTransitionsRepositoryFormatter();
        context = new FormatterContext(writer);
    }

    @Override
    public void format(ILexer lexer, IWriter writer) throws ReaderException, WriterException {
        State state = new State("initial");
        while (lexer.hasMoreTokens() && state != null) {
            IToken token = lexer.readToken();
            ICommandFormatter command = commandRepositoryFormatter.getCommand(state, token);
            command.execute(token, context);
            //System.out.println(state + " STATE");
            state = stateTransitionsRepositoryFormatter.getNextState(state, token);
        }
    }
}
