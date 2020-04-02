package Sevryugin;

import Sevryugin.annotation.Entity;
import Sevryugin.annotation.Value;
import Sevryugin.exception.IllegalStateException;
import Sevryugin.exception.NoValueAnnotationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * Класс реализует методы, необходимые для выполнения заданий
 */
public class Service {
    private static final Logger log = LoggerFactory.getLogger(Service.class);

    /**
     * Метод реализует проверку входящего класса на наличие @Entity и @Value
     *
     * @param clazz - входящий класс
     */
    public void task4(Class clazz) {
        if (checkEntityAnnotation(clazz)) {
            log.info("у " + clazz.getName() + " есть @Entity");
            if (checkValueAnnotation(clazz)) {
                log.info("у : " + clazz.getName() + " есть хотя бы одно поле с @Value");
            } else {
                throw new NoValueAnnotationException("у : " + clazz.getName() + " нет поля с @Value");
            }
        } else {
            log.info("у " + clazz.getName() + " нет @Entity");
            if (checkValueAnnotation(clazz)) {
                throw new IllegalStateException("у " + clazz.getName() + " есть хотя бы одно поле с @Value");
            } else {
                log.info("у " + clazz.getName() + " нет поля с @Value");
            }

        }
    }

    /**
     * Метод проверяет, аннотирован ли класс @Entity
     *
     * @param clazz - класс, который нелбходимо проверить
     * @return - true - @Entity у класса есть, false - нету
     */
    public static boolean checkEntityAnnotation(Class clazz) {
        if (clazz.isAnnotationPresent(Entity.class)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод проверяет входящий класс на наличие @Value
     *
     * @param clazz - класс для проверки
     * @return - true - содержит, false - не содержит
     */
    public static boolean checkValueAnnotation(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Value.class))
                return true;
        }
        return false;
    }

}
