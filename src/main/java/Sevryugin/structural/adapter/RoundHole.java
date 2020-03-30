package Sevryugin.structural.adapter;

/**
 * Класс описывающий круглую лунку определенного радиуса
 */
public class RoundHole {
    private int radius;

    public RoundHole(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "RoundHole{" +
                "radius=" + radius +
                '}';
    }

    public boolean fits(RoundPeg peg){
        return this.radius >= peg.getRadius();
    }
}
