package Sevryugin.exception;

/**
 * У класса нет @Entity, но есть @Value
 */
public class IllegalStateException extends RuntimeException {
    public IllegalStateException(String message){
        super(message);
    }
}
