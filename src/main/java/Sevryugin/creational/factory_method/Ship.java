package Sevryugin.creational.factory_method;

public class Ship implements Transport {
    private String name;

    public Ship() {
    }

    public Ship(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                '}';
    }

    public String deliver() {
        return "доставка лодкой";
    }
}
