package Sevryugin.creational.abstract_factory.implement;

import Sevryugin.creational.abstract_factory.interfaces.Truck;

public class OldTruck implements Truck {
    @Override
    public String descriptionTrack() {
        return "старый грузовик";
    }
}
