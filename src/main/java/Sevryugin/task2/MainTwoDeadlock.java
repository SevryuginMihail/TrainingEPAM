package Sevryugin.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс, который избавился от проблеммы deadlock
 */
public class MainTwoDeadlock {
    private static final Logger log = LoggerFactory.getLogger(MainTwoDeadlock.class);
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    public static void main(String[] args) {
        log.info(" ");
        Runnable taskOne = () -> {
            synchronized (Lock1) {
                log.info("Thread 1: Holding lock 1...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
                log.info("Thread 1: Waiting for lock 2...");

                synchronized (Lock2) {
                    log.info("Thread 1: Holding lock 1 & 2...");
                }
            }
        };
        Runnable taskTwo = () -> {
            synchronized (Lock1) {
                log.info("Thread 2: Holding lock 2...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
                log.info("Thread 2: Waiting for lock 1...");

                synchronized (Lock2) {
                    log.info("Thread 2: Holding lock 1 & 2...");
                }
            }
        };
        Thread threadOne = new Thread(taskOne);
        Thread threadTwo = new Thread(taskTwo);
        threadOne.start();
        threadTwo.start();
    }
}
