package Sevryugin.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Класс реализует чат как стек с заданным максимальным размером,
 * в который мохно класть или доставать объекты реализации SMS_I
 */
public class Chat {
    private static final Logger log = LoggerFactory.getLogger(Chat.class);
    private int capacity;
    private ArrayList<SMS_I> storage;

    public Chat(int capacity) {
        this.capacity = capacity;
        this.storage = new ArrayList<>();
    }

    /**
     * Метод реализует получение SMS с вершины стека
     * @return - при екеулевом заполнении хранилища - SMS с вершины стека
     *         - иначе null, так как в хранилище пусто
     */
    public SMS_I getSMS(){
        if(storage.size()>0) {
            return this.storage.remove(storage.size());
        }
        else
            return null;
    }

    /**
     * Метод кладет на вершину стека SMS
     * @param sms_i - отправленное в чат SMS
     */
    public void sendSMS(SMS_I sms_i){
        if(storage.size() < capacity){
            storage.add(sms_i);
        }
    }
}
