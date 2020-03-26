package Sevryugin.utility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Sevryugin.exception.CommandException;
import lombok.extern.slf4j.Slf4j;

/**
 * Класс реализует логику по чтению из файла
 */
@Slf4j
public class MyFileReader {
    /**
     * Метод переводит файл в массив строк
     *
     * @param fileName - название файла
     * @return - массив строк
     * @throws CommandException - оштбка работы с файлом
     */
    public static List<String> parseFileToString(String fileName) throws CommandException {
        File myFile = new File(fileName);
        List<String> lines = new ArrayList<>();
        if (myFile.exists()) {
            log.info("MyFileReader : файл с таким названием существует");
        } else {
            log.warn("MyFileReader : файл с таким названием не существует");
            try {
                if (myFile.createNewFile()) {
                    log.info("MyFileReader : файл с таким названием успешно создан");
                }
            } catch (IOException e) {
                log.error("MyFileReader : файл с таким названием не удалось создать");
                log.error(e.getMessage());
            }
        }
        // непосредственно работа с файлом
        try {
            BufferedReader bin = new BufferedReader(new FileReader(fileName));
            while (bin.ready())
                lines.add(bin.readLine());
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
            throw new CommandException(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new CommandException(e.getMessage());
        }
        return lines;
    }
}
