package Sevryugin.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TV implements Device {
    private static final Logger log = LoggerFactory.getLogger(MainBridge.class);
    private String name;
    private boolean status;
    private int volume;
    private int channel;

    public TV() {
        log.info("TV : использовани пустой конструктор");
    }

    public TV(String name) {
        this.name = name;
        this.status = false;
        this.volume = 0;
        this.channel = 0;
        log.info("TV : использовани конструктор (name)");
    }

    @Override
    public boolean isEnabled() {
        return this.status;
    }

    @Override
    public void disable() {
        this.status = false;
        log.info("TV : " + this.name + " status = false");
    }

    @Override
    public void enable() {
        this.status = true;
        log.info("TV : " + this.name + " status = true");
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public void setVolume(int percent) {
        this.volume = percent;
        log.info("TV : " + this.name + " volume = "+this.volume);
    }

    @Override
    public int getChannel() {
        return this.channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        log.info("TV : " + this.name + " channel = "+this.channel);
    }

    @Override
    public String toString() {
        return "TV{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", volume=" + volume +
                ", channel=" + channel +
                '}';
    }
}
