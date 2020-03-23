package Sevryugin.task3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main3 {
    public static void main(String[] args) {
        log.info(" ");
        MyClassLoader myClassLoader = new MyClassLoader("D:\\myClasses");
        Class<?> clazz;
        try {
            clazz = myClassLoader.loadClass("TestClass");
            log.info("загружен : " + clazz.getName() + ".class");
            Object object = clazz.newInstance();
            System.out.println(object);
        } catch (ClassNotFoundException e) {
            log.error("Main3 : " + e.getMessage());
        } catch (IllegalAccessException e) {
            log.error("Main3 : " + e.getMessage());
        } catch (InstantiationException e) {
            log.error("Main3 : " + e.getMessage());
        }
        System.out.println("конец работы программы");
    }
}
