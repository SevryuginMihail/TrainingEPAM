package Sevryugin.handlers;

import Sevryugin.exception.CommandException;
import Sevryugin.utility.MyFileReader;
import Sevryugin.utility.MyFileWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class DeleteCommand implements CommandHandler {
    private Logger fileLogger = LoggerFactory.getLogger(Sevryugin.handlers.DeleteCommand.class);

    @Override
    public void execute(String string) throws CommandException {
        fileLogger.info("DeleteCommand : пришла команда : " + string);
        Scanner scanner = new Scanner(string);
        scanner.next();
        int lineInFile = 0;
        boolean valueInFile = scanner.hasNextInt();
        if (valueInFile) {
            lineInFile = scanner.nextInt();
        }
        String fileName = scanner.next();
        fileLogger.info("DeleteCommand : параметры команды : " + lineInFile + " " + fileName);
        File myFile = new File(fileName);
        if(!myFile.exists()){
            fileLogger.error("DeleteCommand : файла с названием : "+fileName +" не существует");
            throw new CommandException("MyFilePrinter : файла с названием : "+fileName +" не существует");
        }
        List<String> lines = MyFileReader.parseFileToString(fileName);
        if (valueInFile) {
            if (lineInFile > lines.size()){
                fileLogger.warn("DeleteCommand : строки с номером : "+lineInFile + " не существует в файле : "+fileName);
                throw new CommandException("DeleteCommand : строки с номером : "+lineInFile + " не существует в файле : "+fileName);
            }
            lines.remove(lineInFile - 1);
        } else {
            lines.remove(lines.size() - 1);
        }
        MyFileWriter.writeFile(fileName, lines);
        fileLogger.info("DeleteCommand : окончание работы обработчика DeleteCommand");
    }
}
