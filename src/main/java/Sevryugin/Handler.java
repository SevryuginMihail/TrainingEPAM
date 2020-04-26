package Sevryugin;

import lombok.extern.slf4j.Slf4j;

/**
 * Handler.
 *
 * @author Mihail_Sevryugin
 */
@Slf4j
public class Handler {
    public void switchHandler(Integer taskNumber){
        log.info("Обработчик, задача :{}",taskNumber);
        switch (taskNumber){
            case 0:{exit();break;}
            case 1:{break;}
            case 2:{break;}
            case 3:{break;}
            case 4:{break;}
            case 5:{break;}
        }
    }
    public static void exit(){
        log.info("Выход из программы");
    }
}
