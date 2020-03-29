package Sevryugin.creational.abstract_factory.implement;

import Sevryugin.creational.abstract_factory.interfaces.PassengerCar;

public class OldPassengerCar implements PassengerCar {
    @Override
    public String descriptionPassengerCar() {
        return "старая легковушка";
    }
}
