package Sevryugin;
import Sevryugin.task1.MyStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        log.info(" ");
        MyStream myStream = new MyStream();
        myStream.writeUuidInFile();
        myStream.valueUuid();
    }
}
