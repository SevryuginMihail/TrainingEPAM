package Sevryugin.filter;

import Sevryugin.exception.CommandException;
import Sevryugin.exception.WrongCommandException;
import Sevryugin.handlers.*;
import Sevryugin.utility.CommandName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс вызывает обработчик в соответствии с пришедшей командой
 */
public class Filter {
    private Logger fileLogger = LoggerFactory.getLogger(Sevryugin.filter.Filter.class);
    private Pattern pattern;
    HashMap<String, CommandName> stringCommandNameHashMap;
    HashMap<CommandName, CommandHandler> handlerHashMap;

    public Filter() {
        pattern = Pattern.compile("^" +
                "|(delete\\s(\\w+(.txt)?|[1-9]+\\d*\\s\\w+(.txt)?))" +
                "|(print\\s(\\w+(.txt)?|[1-9]+\\d*\\s\\w+(.txt)?))" +
                "|(add\\s(\\w+(.txt)?\\s\"\\w+\"|[1-9]+\\d*\\s\\w+(.txt)?\\s\"\\w*\"))" +
                "|(exit)" +
                "|$");
        stringCommandNameHashMap = new HashMap<>();
        stringCommandNameHashMap.put("add", CommandName.ADD);
        stringCommandNameHashMap.put("delete", CommandName.DELETE);
        stringCommandNameHashMap.put("exit", CommandName.EXIT);
        stringCommandNameHashMap.put("print", CommandName.PRINT);
        handlerHashMap = new HashMap<>();
        handlerHashMap.put(CommandName.ADD, new AddCommand());
        handlerHashMap.put(CommandName.DELETE, new DeleteCommand());
        handlerHashMap.put(CommandName.EXIT, new ExitCommand());
        handlerHashMap.put(CommandName.PRINT, new PrintCommand());
    }

    /**
     * Метод проверяет пришедшую команду на валидность, передает ее соответствующему обработчику
     *
     * @param command - пришедшая команда
     * @throws WrongCommandException - пришедшая строка не валидна
     * @throws CommandException      - не удалось прочитать используемый файл
     */
    public void execute(String command) throws WrongCommandException, CommandException {
        fileLogger.info(" ");
        fileLogger.info("Filter : в фильтр передана строка : " + command);
        Matcher matcher = pattern.matcher(command);
        if (matcher.matches()) {
            fileLogger.info("Filter : строка : " + command + " валидна");
            Scanner scanner = new Scanner(command);
            scanner.useDelimiter(" ");
            CommandName commandName = stringCommandNameHashMap.get(scanner.next());
            handlerHashMap.get(commandName).execute(command);
        } else {
            fileLogger.info("Filter : строка : " + command + " не валидна");
            throw new WrongCommandException("Команда неверна: " + command);
        }
        fileLogger.info("Filter : окончание работы Filter");
    }
}
