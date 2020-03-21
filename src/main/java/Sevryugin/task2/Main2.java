package Sevryugin.task2;

public class Main2 {
    public static void main(String[] args) {
        genStackOverFlowError("by");
    }
    public static void genStackOverFlowError(String s){
        try{
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        genStackOverFlowError(s);
    }
}
