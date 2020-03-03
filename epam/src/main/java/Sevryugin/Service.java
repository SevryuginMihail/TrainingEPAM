package Sevryugin;

public class Service {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Human human =new Human();
        human = human.createRandomHuman();
        DtoHuman dtoHuman = new DtoHuman();
        Convertor<Human, DtoHuman> convertor = new Convertor<>();
        System.out.println(human);
        System.out.println();
        //dtoHuman =
                convertor.convert(human, dtoHuman);
    }
}
