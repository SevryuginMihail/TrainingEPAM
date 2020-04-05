package Sevryugin.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class MyTree {
    private static final Logger log = LoggerFactory.getLogger(MyTree.class);

    public static void main(String[] args) {
        //MyTree tree = new MyTree();
        //System.out.println(Paths.get("").toAbsolutePath().toString());// абсолютный путь проекта
        //fileInfo("D:\\Games");// данные об объекте по введенному пути
        recurs(0,"D:\\example");
    }

    /**
     * Метод рекурсивно обходит все дерево директорий
     */
    public static void recurs(Integer spaceCount, String filePath) {
        File rootFile = new File(filePath);
        File[] files = rootFile.listFiles();
        if (files != null) {
            for (File file : files) {
                if(file!=null) {
                    fileInfo(spaceCount + 1, file.getAbsolutePath());
                    System.out.println();
                    recurs(spaceCount++, file.getAbsolutePath());
                }
            }
        }
    }

//    public void dirInfo(String filePath) {
//        File dir = new File(filePath);
//        System.out.println(dir.getAbsolutePath());
//        File[] list1 = dir.listFiles();
//        for (File file : list1) {
//            //fileInfo(file.getAbsolutePath());
//            System.out.println();
//        }
//    }

    public static void fileInfo(Integer spaceCount, String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            // пробелы для удобного представления дерева
            for(int i=0;i<spaceCount;i++)
                System.out.print(" ");
            System.out.print(file.getName());
            System.out.print(" ");
            if (file.isDirectory())
                System.out.print("dir");
            if (file.isFile())
                System.out.print("file");
            System.out.print(" ");
            //rwx из linux
            if (file.canRead()) {
                System.out.print("r");
            } else {
                System.out.print("-");
            }
            if (file.canWrite()) {
                System.out.print("w");
            } else {
                System.out.print("-");
            }
            if (file.canExecute()) {
                System.out.print("x");
            } else {
                System.out.print("-");
            }
        }
    }

    /**
     * Выводит в консоль полные данные об объекте файловой системы
     *
     * @param filePath - путь к объекту
     */
    public static void fileFullInfo(String filePath) {
        File fl = new File(filePath);
        if (fl.exists()) {
            System.out.println("Файл существует");
            System.out.println("Имя файла: " + fl.getName());
            System.out.println("Путь: " + fl.getPath());
            System.out.println("Полный путь: " + fl.getAbsolutePath());
            System.out.println("Родительский каталог: " + fl.getParent());
            System.out.println(fl.canWrite() ?
                    "Свойство - можно записывать" :
                    "Свойство - нельзя записывать");
            System.out.println(fl.canRead() ?
                    "Свойство - можно читать" :
                    "Свойство - нельзя читать");
            System.out.println("Это директория ? " +
                    (fl.isDirectory() ?
                            "да" : " нет"));
            System.out.println("Это обычный файл ? " +
                    (fl.isFile() ?
                            "да" : "нет"));
            System.out.println("Последняя модификация файла : " + fl.lastModified());
            System.out.println("Размер файла : " + fl.length() + " bytes");
        } else {
            System.out.println("Файл  не существует");
        }
    }
}
