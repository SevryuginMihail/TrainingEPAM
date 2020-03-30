package Sevryugin.creational.abstract_factory.factories;

import Sevryugin.creational.abstract_factory.implement.NewPassengerCar;
import Sevryugin.creational.abstract_factory.implement.NewTruck;
import Sevryugin.creational.abstract_factory.interfaces.PassengerCar;
import Sevryugin.creational.abstract_factory.interfaces.Truck;

public class NewRoadLogistic extends LogisticCAF {
    @Override
    public PassengerCar createPassengerCar() {
        return new NewPassengerCar();
    }

    @Override
    public Truck createTruck() {
        return new NewTruck();
    }
}
