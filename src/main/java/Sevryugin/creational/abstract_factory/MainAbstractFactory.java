package Sevryugin.creational.abstract_factory;

import Sevryugin.creational.abstract_factory.factories.LogisticCAF;
import Sevryugin.creational.abstract_factory.factories.NewRoadLogistic;
import Sevryugin.creational.abstract_factory.factories.OldRoadLogistic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainAbstractFactory {
    private static final Logger log = LoggerFactory.getLogger(MainAbstractFactory.class);
    private static LogisticCAF logistic;

    public static void main(String[] args) {
        configure();
        work();
    }

    public static void configure() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\propertiesAbstractFactory.txt"));
            log.info(" ");
            String s = bufferedReader.readLine();
            log.info("прочитана строка : " + s);
            if (s.equals("old")) {
                logistic = new OldRoadLogistic();
            } else if (s.equals("new")) {
                logistic = new NewRoadLogistic();
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
        log.info(logistic.createPassengerCar().descriptionPassengerCar());
        log.info(logistic.createTruck().descriptionTrack());
    }
}
