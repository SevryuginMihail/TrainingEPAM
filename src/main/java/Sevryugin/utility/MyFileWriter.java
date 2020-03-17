package Sevryugin.utility;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

@Slf4j
public class MyFileWriter {
    public static void writeFile(String fileName, List<String> lines){
        log.info("MyFileWriter : осуществляется запись в файл : " + fileName);
        try (BufferedWriter bout = new BufferedWriter(new FileWriter(fileName, false))){
            for (int i=0 ; i<lines.size() - 1; i++) {
                bout.write(lines.get(i) + "\n");
            }
            // Запись последней строчки без перехода на новую строку
            bout.write(lines.get(lines.size()-1));
        } catch (Exception e){
            log.error("MyFileWriter : не удалось осуществить запись в файл : "+ fileName);
            log.error(e.getMessage());
        }
        log.info("MyFileWriter : окончена запись в файл : " + fileName);
    }
}
