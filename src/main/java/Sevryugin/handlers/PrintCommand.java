package Sevryugin.handlers;

import Sevryugin.exception.CommandException;
import Sevryugin.utility.MyFilePrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class PrintCommand implements CommandHandler {
    private Logger fileLogger = LoggerFactory.getLogger(Sevryugin.handlers.PrintCommand.class);

    @Override
    public void execute(String string) throws CommandException {
        fileLogger.info("PrintCommand : пришла команда : " + string);
        Scanner scanner = new Scanner(string);
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
