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
        if(myFile.exists()){
            log.info("MyFileReader : файл с таким названием существует");
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

        }else{
            log.error("MyFileReader : файл с таким названием не существует");
            throw new CommandException("файл с таким названием не существует");
        }
        return lines;
    }
}
