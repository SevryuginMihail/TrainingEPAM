package Sevryugin.structural.adapter;

/**
 * Класс описывает колышек круглого сечения
 */
public class RoundPeg {
    private int radius;

    public RoundPeg(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "RoundPeg{" +
                "radius=" + radius +
                '}';
    }
}
