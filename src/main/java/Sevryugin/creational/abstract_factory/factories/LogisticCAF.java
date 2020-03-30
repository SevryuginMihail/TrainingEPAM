package Sevryugin.creational.abstract_factory.factories;

import Sevryugin.creational.abstract_factory.interfaces.PassengerCar;
import Sevryugin.creational.abstract_factory.interfaces.Truck;

public abstract class LogisticCAF {
    public abstract PassengerCar createPassengerCar();

    public abstract Truck createTruck();
}
