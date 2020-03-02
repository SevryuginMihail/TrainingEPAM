package Sevryugin;

import lombok.Data;
import java.util.Date;

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

    public DtoHuman(String name, int year, int month, int date, Integer houseNumber, String street, Integer apartmentNumber, String town, String country) {
        this.id = ++idConst;
        this.name = name;
        this.birthDate = new Date(year, month, date);
        this.dtoAddress = new DtoAddress(houseNumber, street, apartmentNumber, town, country);
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
