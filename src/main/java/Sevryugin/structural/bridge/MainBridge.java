package Sevryugin.structural.bridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainBridge {
    private static final Logger log = LoggerFactory.getLogger(MainBridge.class);

    public static void main(String[] args) {
        log.info("");
        TV tv = new TV("зомбиящик");
        Remote remote = new Remote(tv);
        log.info(tv.toString());
        remote.togglePower();
        remote.channelUp();
        remote.volumeUp();
        log.info(tv.toString());
    }
}
