package Sevryugin.creational.abstract_factory.implement;

import Sevryugin.creational.abstract_factory.interfaces.PassengerCar;

public class NewPassengerCar implements PassengerCar {
    @Override
    public String descriptionPassengerCar() {
        return "новая легковушка";
    }
}
