package Sevryugin.behavioral.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс реализует паттерн стратегия на примере операций : +, - , *
 */
public class MainStrategy {
    private static final Logger log = LoggerFactory.getLogger(MainStrategy.class);

    public static void main(String[] args) {
        log.info("");
        StrategyEnum action = StrategyEnum.ADD;
        log.info("MainStrategy : выбрана лперация : " + action);
        int firstValue = 10;
        int secondValue = 32;
        log.info("MainStrategy : значения переменных : " + firstValue + " " + secondValue);
        Context context = new Context();
        if (action == StrategyEnum.ADD)
            context.setStrategy(new ConcreteStrategyAdd());
        if (action == StrategyEnum.SUB)
            context.setStrategy(new ConcreteStrategySubstract());
        if (action == StrategyEnum.MULTI)
            context.setStrategy(new ConcreteStrategyMultiply());
        int result = context.executeStrategy(firstValue, secondValue);
        log.info("MainStrategy : результат операции : " + result);
    }
}
