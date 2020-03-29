package Sevryugin.creational.factory_method;

public class RoadLogistic extends Logistics {
    @Override
    public Transport createTransport() {
        return new Car();
    }
}
