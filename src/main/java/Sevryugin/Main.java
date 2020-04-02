package Sevryugin;

import Sevryugin.exception.IllegalStateException;
import Sevryugin.exception.NoValueAnnotationException;
import Sevryugin.pojo.Car;
import Sevryugin.pojo.Human;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info(" ");
        Service service = new Service();
        Car car = new Car(20,"black");
        Human human1 = new Human(20,"Ivan");
        Human human2 = new Human();
        log.info(human2.toString());
        try{
            service.task4(human1.getClass());
            service.task4(car.getClass());

        }catch (IllegalStateException e){
            log.error(e.getMessage());
        }catch (NoValueAnnotationException e) {
            log.error(e.getMessage());
        }

    }
}
