package Sevryugin.handlers;

import Sevryugin.exception.CommandException;
import Sevryugin.utility.MyFilePrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Класс реализует обработчик команды "печать из файла"
 */
public class PrintCommand implements CommandHandler {
    private Logger fileLogger = LoggerFactory.getLogger(Sevryugin.handlers.PrintCommand.class);

    /**
     * Метод производит вывод в консоль части файла слгласно пришедшей команде
     *
     * @param command - обрабатываемая команда
     * @throws CommandException - ошибка работы с файлом
     */
    @Override
    public void execute(String command) throws CommandException {
        fileLogger.info("PrintCommand : пришла команда : " + command);
        Scanner scanner = new Scanner(command);
        scanner.next();
        int lineInFile = 0;
        boolean valueInFile = scanner.hasNextInt();
        if (valueInFile) {
            lineInFile = scanner.nextInt();
        }
        String fileName = scanner.next();
        fileLogger.info("PrintCommand : параметры команды : " + lineInFile + " " + fileName);
        if (valueInFile) {
            MyFilePrinter.printLineFromFile(fileName, lineInFile);
        } else {
            MyFilePrinter.printFile(fileName);
        }
        fileLogger.info("PrintCommand : окончание работы обработчика PrintCommand");
    }
}
