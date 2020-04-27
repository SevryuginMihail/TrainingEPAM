package Sevryugin;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * Menu. Класс предоставляет возможность выбора запроса из меню
 *
 * @author Mihail_Sevryugin
 */
@Slf4j
public class Menu {
    private static Integer valueOperations = 6;
    /**
     * Метод осуществляет беконечный цикл выбора задачи с возможностью выхода
     */
    public static void menu(){
        Integer task_number = -10;
        Scanner scanner = new Scanner(System.in);
        Handler handler = new Handler();
        while(task_number != 0){
            log.info(viewMenu());
            log.info("Введити номер запроса");
            if(scanner.hasNextInt()){
                task_number=scanner.nextInt();
                log.info("Вы ввели :{}",task_number);
                if(task_number>=0 && task_number<=valueOperations) {
                    handler.switchHandler(task_number);
                    task_number = -1;
                }
                else{
                    log.info("Запроса с таким номером не существует, повторите попытку");
                }
            }else {
                log.info("Введенная строка не является числом, повторите попытку");
            }
        }
    }
    public static String viewMenu(){
        return  "\n0 - Выход из программы" +
                "\n1 - Запрос на просмотр всей таблицы properties"+
                "\n2 - Запрос на просмотр по введенному title"+
                "\n3 - Запрос на изминение title по заданному id"+
                "\n4 - Запрос на удаление по id"+
                "\n5 - Запрос на добавление";
    }
}
