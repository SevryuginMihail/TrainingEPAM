package Sevryugin;

import lombok.Data;

import java.util.Date;
import static java.lang.Math.random;
@Data
public class DtoHuman {
    private static Integer idConst = 0;
    private Integer id;
    private String name;
    private Date birthDate;
    private DtoAddress dtoAddress;

    public DtoHuman() {
        this.id = idConst;// или ++idConst?
        this.name = "name";
        this.birthDate = new Date();
        this.dtoAddress = new DtoAddress();
    }

    public DtoHuman(int id,String name, int year, int month, int date, Integer houseNumber, String street, Integer apartmentNumber, String town, String country) {
        this.id = id;
        this.name = name;
        this.birthDate = new Date(year, month, date);
        this.dtoAddress = new DtoAddress(houseNumber, street, apartmentNumber, town, country);
    }

    public DtoHuman createRandomDtoHuman() {
        String nameRandom[] = {"Василий", "Петр", "Кирилл", "Алексей", "Роман", "Тихон","Герман"};// случайное имя
        Integer yearRandom = 1800 + (int) (random() * 220);
        Integer monthRandom = 1 + (int) (random() * 11);
        Integer dateRandom = 1 +(int)(random()*28);
        Integer houseNumberRandom = 1 + (int)(random()*1000);
        String streetRandom[]={"Арбат","Фонтанка","Центральная","Молодежная","Школьная","Лесная","Садовая","Безымянная"};
        Integer apartmentNumberRandom = 1 + (int)(random()*1000);
        String townRandom[]={"Москва","Челябинск","Северодвинск","Одесса","Екатеринбург","Новосибирск","Караганда"};
        String country = "Россия";
        DtoHuman dtoHuman = new DtoHuman(++idConst,nameRandom[(int)(random()*nameRandom.length)],yearRandom,monthRandom,dateRandom,
                houseNumberRandom,streetRandom[(int)(random()*streetRandom.length)],apartmentNumberRandom,
                townRandom[(int)(random()*townRandom.length)],country);
        return dtoHuman;
    }

    @Data
    protected class DtoAddress {
        private Integer houseNumber;
        private String street;
        private Integer apartmentNumber;
        private String town;
        private String country;

        DtoAddress() {
            this.houseNumber = 0;
            this.street = "";
            this.apartmentNumber = 0;
            this.town = "";
            this.country = "";
        }

        DtoAddress(Integer houseNumber, String street, Integer apartmentNumber, String town, String country) {
            this.houseNumber = houseNumber;
            this.street = street;
            this.apartmentNumber = apartmentNumber;
            this.town = town;
            this.country = country;
        }
    }
}
