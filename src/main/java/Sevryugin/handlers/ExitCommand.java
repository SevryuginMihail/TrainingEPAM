package Sevryugin.handlers;

import Sevryugin.exception.CommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс реализует обработчик команды "закрытие программы"
 */
public class ExitCommand implements CommandHandler {
    private Logger fileLogger = LoggerFactory.getLogger(Sevryugin.handlers.ExitCommand.class);

    /**
     * Метод прерывания работы программы
     *
     * @param command - обрабатываемая команда
     */
    @Override
    public void execute(String command) throws CommandException {
        fileLogger.info("ExitCommand : пришла команда : " + command);
        fileLogger.info("окончание работы программы");
        System.exit(0);
    }
}
