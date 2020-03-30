package Sevryugin.structural.bridge;

public interface Device {
    public boolean isEnabled();
    public void disable();
    public void enable();
    public int getVolume();
    public void setVolume(int percent);
    public int getChannel();
    public void setChannel(int channel);
}
