package Sevryugin;
import lombok.Data;
@Data
public class Convertor {
    public Human convert(DtoHuman dtoHuman) {
        Human human;
        human = new Human(dtoHuman.getName(),dtoHuman.getBirthDate().getYear(),dtoHuman.getBirthDate().getMonth(),
                dtoHuman.getBirthDate().getDate(),dtoHuman.getDtoAddress().getHouseNumber(),dtoHuman.getDtoAddress().getStreet(),
                dtoHuman.getDtoAddress().getApartmentNumber(),dtoHuman.getDtoAddress().getTown(),dtoHuman.getDtoAddress().getCountry());
        return human;
    }
    public DtoHuman convert(Human human){
        DtoHuman dtoHuman;
        dtoHuman = new DtoHuman(human.getName(),human.getBirthDate().getYear(),human.getBirthDate().getMonth(),human.getBirthDate().getDate(),
                human.getAddress().getHouseNumber(),human.getAddress().getStreet(),human.getAddress().getApartmentNumber(),
                human.getAddress().getTown(),human.getAddress().getCountry());
        return dtoHuman;
    }
}
