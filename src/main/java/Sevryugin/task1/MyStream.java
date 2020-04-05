package Sevryugin.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс реализует запись в файл 10_000 UUID,
 * осуществляет подсчет количества UUID, сумма цифр которого больше 100
 * находит дату конца света
 */
public class MyStream {
    private static final Logger log = LoggerFactory.getLogger(MyStream.class);

    /**
     * Метод производит запись в файл построчно UUID
     */
    public void writeUuidInFile() {
        Path path =Paths.get("uuid.txt");
        Integer countUUID =10_000;
        log.info("Файл для вывода UUID : {}",path);
        try {
            Files.delete(path);
            Files.write(path, Arrays.asList(Stream.generate(UUID::randomUUID)
                    .limit(countUUID)
                    .collect(Collectors.toList())
                    .toString()
                    .replace("[", "")
                    .replace("]", "")
                    .split(", ")));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.info("произведено создание и запись в файл {} {} переменных", path ,countUUID);
    }

    /**
     * Метод осуществляет подсчет UUID, сумма цифр которого больше 100
     * @return - количество UUID, сумма цифр которого больше 100
     */
    public long valueUuid() {
        long count = 0;
        try {
            count = Files.lines(Paths.get("uuid.txt"))
                    .map((s) -> s.replaceAll("\\D", ""))
                    .map((s) -> s.chars().map(Character::getNumericValue).sum())
                    .filter((s) -> s > 100)
                    .count();
            log.info("подсчет окончен : {}",count);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return count;
    }

    /**
     * Метод возвращает дату конца света
     *
     * @param count - входящее четырехзначное значение
     */
    public void findEndOfTheWorld(Long count) {
        Long days = count % 100;
        Long months = count / 100;
        LocalDateTime localDateTime;
        localDateTime = LocalDateTime.parse(
                LocalDateTime.now()
                        .plusMonths(months)
                        .plusDays(days)
                        .atZone(ZoneId.of("America/Los_Angeles"))
                        .toLocalDateTime()
                        .format(DateTimeFormatter.ISO_DATE_TIME));
        log.info("дата конца света : {}", localDateTime);
    }
}