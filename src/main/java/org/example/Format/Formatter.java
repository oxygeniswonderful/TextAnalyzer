package org.example.Format;
import org.example.Command_for_Formatter.CommandRepositoryFormatter;
import org.example.Command_for_Formatter.ICommandFormatter;
import org.example.Lexer.ILexer;
import org.example.Reader.ReaderException;
import org.example.Token.IToken;
import org.example.Writer.IWriter;
import org.example.Writer.WriterException;


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
