package Sevryugin.behavioral.strategy;

/**
 * Класс реализует операцию вычитания
 */
public class ConcreteStrategySubstract implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}
