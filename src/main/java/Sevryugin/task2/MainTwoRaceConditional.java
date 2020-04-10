package Sevryugin.task2;

import Sevryugin.task1.ClassWithInt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс, который избавился от проблеммы race conditional
 */
public class MainTwoRaceConditional {
    private static final Logger log = LoggerFactory.getLogger(MainTwoRaceConditional.class);

    public static void main(String[] args) {
        log.info(" ");
        MainTwoRaceConditional mainTaskTwo = new MainTwoRaceConditional();
        mainTaskTwo.goodRaceCondition();
    }

    /**
     * Метод реализует отсутствие race conditional при работе с объектом
     */
    public void goodRaceCondition() {
        log.info("goodRaceCondition");
        ClassWithInt classWithInt = new ClassWithInt();
        Runnable increment = () -> {
            synchronized (classWithInt) {
                for (int i = 0; i < 4; i++) {
                    classWithInt.inc();
                    log.info("inc i={} ,value={}", i, classWithInt.getValue());
                }
            }
        };
        Runnable decrement = () -> {
            synchronized (classWithInt) {
                for (int i = 0; i < 4; i++) {
                    classWithInt.dec();
                    log.info("dec i={} ,value={}", i, classWithInt.getValue());
                }
            }
        };
        Thread threadInc = new Thread(increment);
        Thread threadDec = new Thread(decrement);
        threadInc.start();
        threadDec.start();
    }
}
