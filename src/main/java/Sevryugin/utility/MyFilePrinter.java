package Sevryugin.utility;

import Sevryugin.exception.CommandException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;

/**
 * Класс реализует логику по выводу из файла
 */
@Slf4j
public class MyFilePrinter {
    /**
     * Метод для вывода всего файла в консоль
     *
     * @param fileName - название файла
     * @throws CommandException - ошибка работы с файлом
     */
    public static void printFile(String fileName) throws CommandException {
        log.info("MyFilePrinter : осуществляется печать в консоль файла : " + fileName);
        File myFile = new File(fileName);
        if (!myFile.exists()) {
            log.error("MyFilePrinter : файла с названием : " + fileName + " не существует");
            throw new CommandException("MyFilePrinter : файла с названием : " + fileName + " не существует");
        }
        List<String> lines = MyFileReader.parseFileToString(fileName);
        for (String line : lines) {
            System.out.println(line);
        }
        log.info("MyFilePrinter : окончание печати в консоль файла : " + fileName);
    }

    /**
     * Метод для вывода одной строки из файла в консоль
     *
     * @param fileName - название файла
     * @param line     - номер выводимой строки
     * @throws CommandException
     */
    public static void printLineFromFile(String fileName, int line) throws CommandException {
        log.info("MyFilePrinter : осуществляется печать в консоль строки : " + line + " файла : " + fileName);
        File myFile = new File(fileName);
        if (!myFile.exists()) {
            log.error("MyFilePrinter : файла с названием : " + fileName + " не существует");
            throw new CommandException("MyFilePrinter : файла с названием : " + fileName + " не существует");
        }
        List<String> lines = MyFileReader.parseFileToString(fileName);
        try {
            System.out.println(lines.get(line - 1));
        } catch (Exception e) {
            log.warn("MyFilePrinter : строки с номером : " + line + " не существует в файле : " + fileName);
            throw new CommandException(e.getMessage());
        }
        log.info("MyFilePrinter : окончание печати в консоль строки : " + line + " файла : " + fileName);
    }
}
