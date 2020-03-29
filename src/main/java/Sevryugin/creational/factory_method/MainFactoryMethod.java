package Sevryugin.creational.factory_method;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainFactoryMethod {
    private static final Logger log = LoggerFactory.getLogger(MainFactoryMethod.class);
    private static Logistics logistics;

    public static void main(String[] args) {
        configure();
        work();
    }

    public static void configure() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\propertiesFactoryMethod.txt"));
            log.info(" ");
            String s = bufferedReader.readLine();
            log.info("прочитана строка : " + s);
            if (s.equals("car")) {
                logistics = new RoadLogistic();
            } else if (s.equals("ship")) {
                logistics = new SeaLogistic();
            } else {
                log.error("недопустимое свойство в конфигурационном файле");
                log.error("окончание программы");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public static void work() {
        log.info(logistics.createTransport().deliver());
    }
}
