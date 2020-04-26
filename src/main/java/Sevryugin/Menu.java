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
                if(task_number>=0 && task_number<=valueOperations)
                    handler.switchHandler(task_number);
                else{
                    log.info("Запроса с таким номером не существует, повторите попытку");
                }
            }else {
                log.info("Введенная строка не является числом, повторите попытку");
            }
        }
    }
    public static String viewMenu(){
        return  "0 - Выход из программы" +
                "1 - Запрос на просмотр всей таблицы properties"+
                "2 - Запрос на просмотр по введенному title"+
                "3 - Запрос на изминение title по заданному id"+
                "4 - Запрос на удаление по id"+
                "5 - Запрос на добавление";
    }
}
