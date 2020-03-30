package Sevryugin.behavioral.strategy;

/**
 * Класс реализует операцию умножения
 */
public class ConcreteStrategyMultiply implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}
