package Sevryugin.task1;

import java.util.LinkedList;
import java.util.List;

public class Main1 {
    static final List<Object[]> arrays = new LinkedList<>();
    public static void main(String[] args) {
        for (Integer i=0; ; i++) {
            try{
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrays.add(new Object[100]);
            System.out.println(i);
        }
    }
}
