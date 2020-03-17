package Sevryugin;

import Sevryugin.exception.CommandException;
import Sevryugin.exception.WrongCommandException;
import Sevryugin.filter.Filter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Filter filter = new Filter();
        String string;
        while (true) {
            System.out.println("Введите строку");
            string = scanner.nextLine();
            try{
                filter.execute(string);
            }catch (WrongCommandException | CommandException e){
                System.out.println(e.getMessage());
            }
        }
        //scanner.close();
    }
}
