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

public class Filter {
    private Logger fileLogger = LoggerFactory.getLogger(Sevryugin.filter.Filter.class);
    private Pattern pattern;
    HashMap<String, CommandName> stringCommandNameHashMap;
    HashMap<CommandName, CommandHandler> handlerHashMap;

    public Filter() {
        pattern = Pattern.compile("^" +
                "|(delete\\s(\\w+|[1-9]+\\d*\\s\\w+))" +
                "|(print\\s(\\w+|[1-9]+\\d*\\s\\w+))" +
                "|(add\\s(\\w+\\s\"\\w+\"|[1-9]+\\d*\\s\\w+\\s\"\\w*\"))" +
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

    public void execute(String string) throws WrongCommandException, CommandException {
        fileLogger.info(" ");
        fileLogger.info("Filter : в фильтр передана строка : " + string);
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            fileLogger.info("Filter : строка : " + string + " валидна");
            Scanner scanner = new Scanner(string);
            scanner.useDelimiter(" ");
            CommandName commandName = stringCommandNameHashMap.get(scanner.next());
            handlerHashMap.get(commandName).execute(string);
        } else {
            fileLogger.info("Filter : строка : " + string + " не валидна");
            throw new WrongCommandException("Команда неверна: " + string);
        }
    }
}
