package Sevryugin.creational.abstract_factory.implement;

import Sevryugin.creational.abstract_factory.interfaces.Truck;

public class NewTruck implements Truck {
    @Override
    public String descriptionTrack() {
        return "новый грузовик";
    }
}
