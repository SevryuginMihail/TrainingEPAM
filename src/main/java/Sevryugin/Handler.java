package Sevryugin;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            case 1:{task1();break;}
            case 2:{break;}
            case 3:{break;}
            case 4:{break;}
            case 5:{break;}
        }
    }
    public static void exit(){
        log.info("Выход из программы");
    }
    public static void task1(){
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                            "pay",
                            "pay");
            log.info("Соединение установлено.");
            // тут код
        } catch (ClassNotFoundException e) {
            log.warn(e.getMessage());
        } catch (SQLException e) {
            log.warn(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                    log.info("Соединение закрыто");
                }
            } catch (SQLException e) {
                log.warn(e.getMessage());
            }
        }

    }
}
