package Sevryugin.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Класс реализует создание объектов Sausage из зашифрованного файла
 */
public class MySausageStream {
    private static final Logger log = LoggerFactory.getLogger(MySausageStream.class);

    /**
     * Метод создает List<Sausage> по данным из зашифрованного файла
     * @param fileName - путь к файлу
     */
    public void streamSausage(String fileName) {
        Base64.Decoder decoder = Base64.getDecoder();
        Path pathToFile = Paths.get(fileName);
        try {
            List<Sausage> sausageList = Files.readAllLines(pathToFile)
                    .stream()
                    .filter(Objects::nonNull)
                    .map(decoder::decode)
                    .map(String::new)
                    .map(s -> Arrays.stream(s.split(","))
                            .map(obj -> obj.split("=")[1])
                            .collect(Collectors.toList()))
                    .map(Sausage::new)
                    .collect(Collectors.toList());
            log.info(String.valueOf(sausageList));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
