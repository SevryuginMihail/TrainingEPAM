package Sevryugin.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter {
    private Logger fileLogger = LoggerFactory.getLogger(Sevryugin.Filter.Filter.class);

    public void execute(String string) {
        fileLogger.info("Filter : в фильтр передана строка : " + string);
//        add 5 fileName "text"(может не быть цифры)
//        delete 5 fileName
//        print 4 fileName
        Pattern pattern = Pattern.compile("^(delete\\s[1-9]+\\d*\\s\\w+)" +
                "|(print\\s[1-9]+\\d*\\s\\w+)"+
                "|(add\\s(\\w+\\s\"\\w+\"|[1-9]+\\d*\\s\\w+\\s\"\\w+\"))$");
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()) {
            fileLogger.info("Filter : строка : " + string + " валидна");
        } else {
            fileLogger.info("Filter : строка : " + string + " не валидна");
        }
    }
}
