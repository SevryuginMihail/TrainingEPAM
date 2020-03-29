package Sevryugin.creational.abstract_factory.factories;

import Sevryugin.creational.abstract_factory.implement.OldPassengerCar;
import Sevryugin.creational.abstract_factory.implement.OldTruck;
import Sevryugin.creational.abstract_factory.interfaces.PassengerCar;
import Sevryugin.creational.abstract_factory.interfaces.Truck;

public class OldRoadLogistic extends LogisticCAF {
    @Override
    public PassengerCar createPassengerCar() {
        return new OldPassengerCar();
    }

    @Override
    public Truck createTruck() {
        return new OldTruck();
    }
}
