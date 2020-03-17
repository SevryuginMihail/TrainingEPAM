package Sevryugin.handlers;

import Sevryugin.exception.CommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteCommand implements CommandHandler {
    private Logger fileLogger = LoggerFactory.getLogger(Sevryugin.handlers.DeleteCommand.class);

    @Override
    public void execute(String string) throws CommandException {
        fileLogger.info("DeleteCommand : пришла команда : " + string);
    }
}
