package Sevryugin.structural.adapter;

/**
 * Класс описывает колышек квадратного сечения
 */
public class SquarePeg {
    private int width;

    public SquarePeg(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "SquarePeg{" +
                "width=" + width +
                '}';
    }
}
