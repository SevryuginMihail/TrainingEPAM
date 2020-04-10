package Sevryugin.task1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTaskOne {
    private static final Logger log = LoggerFactory.getLogger(MainTaskOne.class);

    public static void main(String[] args) {
        log.info(" ");
        MainTaskOne mainTaskOne = new MainTaskOne();
        mainTaskOne.badRaceCondition();
    }

    /**
     * Метод реализует наличие race conditional при работе с объектом
     */
    public void badRaceCondition() {
        log.info("badRaceCondition");
        ClassWithInt classWithInt = new ClassWithInt();
        Runnable increment = () -> {
            for (int i = 0; i < 4; i++) {
                classWithInt.inc();
                log.info("inc i={} ,value={}", i, classWithInt.getValue());
            }
        };
        Runnable decrement = () -> {
            for (int i = 0; i < 4; i++) {
                classWithInt.dec();
                log.info("dec i={} ,value={}", i, classWithInt.getValue());
            }
        };
        Thread threadInc = new Thread(increment);
        Thread threadDec = new Thread(decrement);
        threadInc.start();
        threadDec.start();
    }
}
