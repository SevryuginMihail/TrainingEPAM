package Sevryugin;
import lombok.Data;
@Data
public class Human {
    private String fio;
    private Integer age;
    private Address address;
    @Data
    protected class Address{
        private String town;
        private String street;
        private Integer house;
        private Integer flat;
        public Address(String town, String street, Integer house, Integer flat) {
            this.town = town;
            this.street = street;
            this.house = house;
            this.flat = flat;
        }
        public Address() {
            this.town = "";
            this.street = "";
            this.house = null;
            this.flat = null;
        }

    }
    public Human() {
        this.fio = "";
        this.age = null;
        this.address = new Address();
    }
    public Human(String fio, Integer age, Address address) {
        this.fio = fio;
        this.age = age;
        this.address = address;
    }
    public Human(String fio, Integer age, String town, String street, Integer house, Integer flat){
        this.fio = fio;
        this.age = age;
        this.address = new Address(town, street, house, flat);
    }
}
