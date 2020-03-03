package Sevryugin;

import lombok.Data;
import java.util.Date;
import static java.lang.Math.random;
@Data
public class Human {
    private static Integer idConst = 0;
    private Integer id;
    private String name;
    private Date birthDate;
    private Address address;
@Data
protected class Address {
    private Integer houseNumber;
    private String street;
    private Integer apartmentNumber;
    private String town;
    private String country;

    Address() {
        this.houseNumber = 0;
        this.street = "";
        this.apartmentNumber = 0;
        this.town = "";
        this.country = "";
    }

    Address(Integer houseNumber, String street, Integer apartmentNumber, String town, String country) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.town = town;
        this.country = country;
    }
}

    public Human() {
        this.id = idConst;// или ++idConst?
        this.name = "name";
        this.birthDate = new Date();
        this.address = new Address();
    }

    public Human(String name, int year, int month, int date, Integer houseNumber, String street, Integer apartmentNumber, String town, String country) {
        this.id = ++idConst;
        this.name = name;
        this.birthDate = new Date(year, month, date);
        this.address = new Address(houseNumber, street, apartmentNumber, town, country);
    }

    public Human createRandomHuman() {
        String nameRandom[] = {"Василий", "Петр", "Кирилл", "Алексей", "Роман", "Тихон","Герман"};// случайное имя
        Integer yearRandom = 1800 + (int) (random() * 220);
        Integer monthRandom = 1 + (int) (random() * 11);
        Integer dateRandom = 1 +(int)(random()*28);
        Integer houseNumberRandom = 1 + (int)(random()*1000);
        String streetRandom[]={"Арбат","Фонтанка","Центральная","Молодежная","Школьная","Лесная","Садовая","Безымянная"};
        Integer apartmentNumberRandom = 1 + (int)(random()*1000);
        String townRandom[]={"Москва","Челябинск","Северодвинск","Одесса","Екатеринбург","Новосибирск","Караганда"};
        String country = "Россия";
        String n = nameRandom[(int)(random()*nameRandom.length)];
        Human human = new Human(nameRandom[(int)(random()*nameRandom.length)],yearRandom,monthRandom,dateRandom,houseNumberRandom,streetRandom[(int)(random()*streetRandom.length)],apartmentNumberRandom,townRandom[(int)(random()*townRandom.length)],country);
        return human;
    }

    public static void main(String[] args) {// проверка работы
//        //Human human1 = new Human("Вася", 2000, 10, 22, 1, "Советская", 101, "Yalta", "RussiaFederation");
//        //System.out.println(human1);
//        Human human = new Human();
//        Human[] humans = new Human[10];
//        for(int i=0;i<humans.length;i++){
//            humans[i]=human.createRandomHuman();
//            System.out.println(humans[i]);
//        }

    }
}


