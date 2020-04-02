package Sevryugin.exception;

/**
 * У класса с @Entity отсутствуют поля с @Value
 */
public class NoValueAnnotationException extends RuntimeException{
    public NoValueAnnotationException(String message){
        super(message);
    }
}
