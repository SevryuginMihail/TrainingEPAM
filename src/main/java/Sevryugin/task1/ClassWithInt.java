package Sevryugin.task1;

public class ClassWithInt {
    private int value;

    public ClassWithInt() {
        this.value = 0;
    }

    public ClassWithInt(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void inc() {
        this.value++;
    }

    public void dec() {
        this.value--;
    }
}
