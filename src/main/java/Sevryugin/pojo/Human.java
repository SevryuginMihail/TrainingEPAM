package Sevryugin.pojo;

import Sevryugin.annotation.Entity;
import Sevryugin.annotation.Value;

/**
 * pojo класс Human с аннотациями
 */
@Entity
public class Human {
    @Value(stringValue = "18",filePath = "src\\main\\resources\\propertiesHuman.txt")
    private int age;
    @Value(stringValue = "Anton",filePath = "src\\main\\resources\\propertiesHuman.txt")
    private String name;

    public Human() {
    }

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
