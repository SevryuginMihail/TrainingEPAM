package Sevryugin;

import lombok.Data;

import java.util.Date;

/**
 * POJO класс - сущность Human
 */
@Data
public class Human {
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
        this.id = 0;
        this.name = "";
        this.birthDate = new Date();
        this.address = new Address();
    }

    public Human(int id, String name, int year, int month, int date, Integer houseNumber, String street, Integer apartmentNumber, String town, String country) {
        this.id = id;
        this.name = name;
        this.birthDate = new Date(year, month, date);
        this.address = new Address(houseNumber, street, apartmentNumber, town, country);
    }
}



