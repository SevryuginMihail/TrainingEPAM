package Sevryugin.handlers;
import Sevryugin.exception.CommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ExitCommand implements CommandHandler {
    private Logger fileLogger = LoggerFactory.getLogger(Sevryugin.handlers.ExitCommand.class);
    @Override
    public void execute(String string) throws CommandException {
        fileLogger.info("ExitCommand : пришла команда : " + string);
        fileLogger.info("окончание работы программы");
        System.exit(0);
    }
}
