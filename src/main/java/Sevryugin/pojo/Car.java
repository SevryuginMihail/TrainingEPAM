package Sevryugin.pojo;

/**
 * Pojo класс Car без аннотаций
 */
public class Car {
    private int age;
    private String color;

    public Car() {
    }

    public Car(int age, String color) {
        this.age = age;
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
