package Sevryugin;

import Sevryugin.exception.CommandException;
import Sevryugin.exception.WrongCommandException;
import Sevryugin.filter.Filter;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Path currentRelativePath = Paths.get("");
        String s = ((Path) currentRelativePath).toAbsolutePath().toString();
        File dir = new File(s);
        Pattern pattern = Pattern.compile("\\w*(.txt)");
        File[] lst1;
        boolean checkTxt = false;

        Scanner scanner = new Scanner(System.in);
        Filter filter = new Filter();
        String string;
        while (true) {

            try {
                lst1 = dir.listFiles();
                for (File f : lst1) {
                    if (pattern.matcher(f.getName()).matches()) {
                        if (!checkTxt) {
                            System.out.println("файлы с расширением .txt");
                            checkTxt = true;
                        }
                        System.out.println(f.getName());
                    }
                }
            } catch (NullPointerException e) {
                System.out.println(" ");// заглушка
            }


            System.out.println("Введите строку");
            string = scanner.nextLine();
            try {
                filter.execute(string);
            } catch (WrongCommandException | CommandException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
