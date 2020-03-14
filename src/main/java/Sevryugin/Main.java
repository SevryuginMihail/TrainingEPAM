package Sevryugin;

import Sevryugin.Filter.Filter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Filter filter = new Filter();
        String string;
        while (true) {
            System.out.println("Введите строку");
            string = scanner.nextLine();
            filter.execute(string);
        }
        //scanner.close();
    }
}
