package Sevryugin;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.Scanner;

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
            case 2:{task2();break;}
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
            // начало кода
            String request1 = "select * from products";
            PreparedStatement preparedStatement = con.prepareStatement(request1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                log.info(String.format("%-7d|%-8d|%-19s|%-19s|%-7.2f|%-7d|%d",
                        resultSet.getInt("prod_id"),
                        resultSet.getInt("category"),
                        resultSet.getString("title"),
                        resultSet.getString("actor"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getShort("special"),
                        resultSet.getInt("common_prod_id")));
            }
            // конец кода
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

    public static void task2() {
        log.info("Введите title");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                            "pay",
                            "pay");
            log.info("Соединение установлено.");
            // начало кода
            String request2 = "select *\n" +
                    "from products p\n" +
                    "where title = '" + title +"'";
            PreparedStatement preparedStatement = con.prepareStatement(request2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                log.info(String.format("%-7d|%-8d|%-19s|%-19s|%-7.2f|%-7d|%d",
                        resultSet.getInt("prod_id"),
                        resultSet.getInt("category"),
                        resultSet.getString("title"),
                        resultSet.getString("actor"),
                        resultSet.getBigDecimal("price"),
                        resultSet.getShort("special"),
                        resultSet.getInt("common_prod_id")));
            }
            // конец кода
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
    public static void task3(){
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                            "pay",
                            "pay");
            log.info("Соединение установлено.");
            // начало кода

            // конец кода
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