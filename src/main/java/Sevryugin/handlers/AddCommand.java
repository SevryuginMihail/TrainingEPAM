package Sevryugin.handlers;

import Sevryugin.exception.CommandException;
import Sevryugin.utility.MyFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class AddCommand implements CommandHandler{
    private Logger fileLogger = LoggerFactory.getLogger(Sevryugin.handlers.AddCommand.class);

    @Override
    public void execute (String string) throws CommandException {
        fileLogger.info("AddCommand : пришла команда : " + string);
        Scanner scanner = new Scanner(string);
        scanner.next();// проскочили слово команды
        Integer lineInFile = 0;
        if(scanner.hasNextInt()){
            lineInFile = scanner.nextInt();
        }
        String fileName = scanner.next();
        String text = scanner.findInLine("\"\\w*\"");
        text.replace("\"", "");
        fileLogger.info("AddCommand : параметры команды : "+lineInFile + " " + fileName + " " + text);
        List<String> lines = MyFileReader.parseFileToString(fileName);
        
    }

}
