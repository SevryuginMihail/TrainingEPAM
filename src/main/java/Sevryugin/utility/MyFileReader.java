package Sevryugin.utility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Sevryugin.exception.CommandException;
import lombok.extern.slf4j.Slf4j;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
@Slf4j
public class MyFileReader {
    //private Logger fileLogger = LoggerFactory.getLogger(Sevryugin.utility.MyFileReader.class);
    public static List<String> parseFileToString(String fileName) throws CommandException{
        File myFile = new File(fileName);// без директории
        List<String> lines = new ArrayList<>();
        // если файл есть, все хорошо, если его нет - моздается
        if(myFile.exists()){
            log.info("MyFileReader : файл с таким названием существует");
        }else{
            log.warn("MyFileReader : файл с таким названием не существует");
            //throw new CommandException("файл с таким названием не существует");
            try {
                if(myFile.createNewFile()){
                    log.info("MyFileReader : файл с таким названием успешно создан");
                }
            }catch (IOException e){
                log.error("MyFileReader : файл с таким названием не удалось создать");
                log.error(e.getMessage());
            }
        }
        // непосредственно работа с файлом
        try {
            BufferedReader bin = new BufferedReader(new FileReader(fileName));
            while (bin.ready())
                lines.add(bin.readLine());
        }catch ( FileNotFoundException e){
            log.error(e.getMessage());
            throw new CommandException(e.getMessage());
        }
        catch (IOException e){
            log.error(e.getMessage());
            throw new CommandException(e.getMessage());
        }
        return lines;
    }
}
