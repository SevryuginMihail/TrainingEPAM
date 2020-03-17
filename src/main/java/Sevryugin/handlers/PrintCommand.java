package Sevryugin.handlers;
import Sevryugin.exception.CommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class PrintCommand implements CommandHandler {
    private Logger fileLogger = LoggerFactory.getLogger(Sevryugin.handlers.PrintCommand.class);
    @Override
    public void execute(String string) throws CommandException {
        fileLogger.info("PrintCommand : пришла команда : " + string);

    }
}
