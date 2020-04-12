package Sevryugin.task3;

/**
 * pojo класс SMS
 */
public class MySMS implements SMS_I {
    private String message;

    public MySMS() {
    }

    public MySMS(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
