package Sevryugin.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Radio implements Device {
    private static final Logger log = LoggerFactory.getLogger(MainBridge.class);
    private String name;
    private boolean status;
    private int volume;
    private int channel;

    public Radio() {
        log.info("Ratio : использовани пустой конструктор");
    }

    public Radio(String name) {
        this.name = name;
        this.status = false;
        this.volume = 0;
        this.channel = 0;
        log.info("Radio : использовани конструктор (name)");
    }

    @Override
    public boolean isEnabled() {
        return this.status;
    }

    @Override
    public void disable() {
        this.status = false;
        log.info("Radio : " + this.name + " status = false");
    }

    @Override
    public void enable() {
        this.status = true;
        log.info("Radio : " + this.name + " status = true");
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public void setVolume(int percent) {
        this.volume = percent;
        log.info("Radio : " + this.name + " volume = " + this.volume);
    }

    @Override
    public int getChannel() {
        return this.channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        log.info("Radio : " + this.name + " channel = " + this.channel);
    }

    @Override
    public String toString() {
        return "Radio{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", volume=" + volume +
                ", channel=" + channel +
                '}';
    }
}
