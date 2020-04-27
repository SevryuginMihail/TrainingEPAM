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
            case 3:{task3();break;}
            case 4:{task4();break;}
            case 5:{task5();break;}
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
            String request2 = "select * from products p where title = '" + title +"'";
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
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                            "pay",
                            "pay");
            log.info("Соединение установлено.");
            // начало кода
            log.info("Введите id");
            int id = scanner.nextInt();
            scanner.nextLine();
            log.info("Введите title");
            String title = scanner.nextLine();
            PreparedStatement updateTitle = con.prepareStatement("update products set title = ? where prod_id = ?;");
            updateTitle.setString(1, title);
            updateTitle.setInt(2, id);
            updateTitle.execute();
            log.info("Изминение завершено");
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

    public static void task4(){
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                            "pay",
                            "pay");
            log.info("Соединение установлено.");
            // начало кода
            log.info("Введите id");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            PreparedStatement deleteRecord = con.prepareStatement("delete from products where prod_id = ?;");
            deleteRecord.setInt(1, id);
            deleteRecord.execute();
            log.info("Удаление завершено");
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

    public static void task5(){
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=public",
                            "pay",
                            "pay");
            log.info("Соединение установлено.");
            // начало кода
            Scanner scanner = new Scanner(System.in);
            log.info("Введите category(int)");
            Integer category = Integer.parseInt(scanner.nextLine());
            log.info("Введите title(string)");
            String title = scanner.nextLine();
            log.info("Введите actor(string)");
            String actor = scanner.nextLine();
            log.info("Введите price(int)");
            Integer price = Integer.parseInt(scanner.nextLine());
            log.info("Введите special(int)");
            Integer special = Integer.parseInt(scanner.nextLine());
            log.info("Введите common_prod_id(int)");
            Integer prod_id = Integer.parseInt(scanner.nextLine());
            PreparedStatement addRecord = con.prepareStatement("insert into products(category, title, actor," +
                    "price, special, common_prod_id)" +
                    "values(?, ?, ?, ?, ?, ?);");
            addRecord.setInt(1, category);
            addRecord.setString(2, title);
            addRecord.setString(3, actor);
            addRecord.setInt(4, price);
            addRecord.setInt(5, special);
            addRecord.setInt(6, prod_id);
            addRecord.execute();
            log.info("Добавление завершено");
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