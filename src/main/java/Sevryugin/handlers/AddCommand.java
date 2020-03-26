package Sevryugin.handlers;

import Sevryugin.exception.CommandException;
import Sevryugin.utility.MyFileReader;
import Sevryugin.utility.MyFileWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

/**
 * Класс реализует обработчик команды "добавление строки"
 */
public class AddCommand implements CommandHandler {
    private Logger fileLogger = LoggerFactory.getLogger(Sevryugin.handlers.AddCommand.class);

    /**
     * Метод добавляет строку в файл
     *
     * @param command - обрабатываемая команда
     * @throws CommandException - ошибка чтения файла
     */
    @Override
    public void execute(String command) throws CommandException {
        fileLogger.info("AddCommand : пришла команда : " + command);
        Scanner scanner = new Scanner(command);
        scanner.next();
        int lineInFile = 0;
        boolean valueInFile = scanner.hasNextInt();
        if (valueInFile) {
            lineInFile = scanner.nextInt();
        }
        String fileName = scanner.next();
        String text = scanner.findInLine("\"\\w*\"");
        text.replace("\"", "");
        fileLogger.info("AddCommand : параметры команды : " + lineInFile + " " + fileName + " " + text);
        List<String> lines = MyFileReader.parseFileToString(fileName);
        if (valueInFile) {
            for (int i = lines.size(); i < lineInFile - 1; i++) {
                lines.add("");
            }
            lines.add(lineInFile - 1, text);
        } else {
            fileLogger.info("AddCommand : добавление в конец файла строки : " + text);
            lines.add(text);
        }
        MyFileWriter.writeFile(fileName, lines);
        fileLogger.info("AddCommand : окончание работы обработчика AddCommand");
    }
}
