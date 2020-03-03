package Sevryugin;

public class Service {
    public static void main(String[] args) throws ClassNotFoundException {
        Human human =new Human();
        human = human.createRandomHuman();
        DtoHuman dtoHuman = new DtoHuman();
        Convertor<Human, DtoHuman> convertor = new Convertor<>();
        //dtoHuman =
                convertor.convert(human);
    }
}
