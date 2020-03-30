package Sevryugin.behavioral.strategy;

/**
 * Класс реализует операцию сложения
 */
public class ConcreteStrategyAdd implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a + b;
    }
}
