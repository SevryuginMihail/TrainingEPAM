package Sevryugin;
import Sevryugin.task1.MyStream;
import Sevryugin.task2.MySausageStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        log.info(" ");
        MyStream myStream = new MyStream();
        myStream.writeUuidInFile();
        myStream.findEndOfTheWorld(myStream.valueUuid());
        MySausageStream mySausageStream = new MySausageStream();
        mySausageStream.streamSausage("src\\main\\resources\\File.txt");
    }
}
