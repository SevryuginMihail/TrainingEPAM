package Sevryugin.task2;

import java.util.List;
import java.util.Optional;

/**
 * Pojo класс Колбаса
 */
public class Sausage {
    private Optional<String> type;
    private Optional<Integer> weight;
    private Optional<Long> cost;

    public Sausage() {
    }

    public Sausage(String type, int weight, long cost) {
        this.type = Optional.ofNullable(type);
        this.weight = Optional.ofNullable(weight);
        this.cost = Optional.ofNullable(cost);
    }

    public Sausage(List<String> sausageList) {
        this(sausageList.get(0).replace("'", ""),
                Integer.parseInt(sausageList.get(1)),
                Long.parseLong(sausageList.get(2)));
    }

    public Optional<String> getType() {
        return type;
    }

    public void setType(Optional<String> type) {
        this.type = type;
    }

    public Optional<Integer> getWeight() {
        return weight;
    }

    public void setWeight(Optional<Integer> weight) {
        this.weight = weight;
    }

    public Optional<Long> getCost() {
        return cost;
    }

    public void setCost(Optional<Long> cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Sausage{" +
                "type=" + type +
                ", weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
