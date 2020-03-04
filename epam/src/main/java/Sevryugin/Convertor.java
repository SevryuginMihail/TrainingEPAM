package Sevryugin;

import lombok.Data;

@Data
public class Convertor {
    public Human convert(DtoHuman dtoHuman) {
        Human human;
        human = new Human(dtoHuman.getId(),dtoHuman.getName(), dtoHuman.getBirthDate().getYear(), dtoHuman.getBirthDate().getMonth(),
                dtoHuman.getBirthDate().getDate(), dtoHuman.getDtoAddress().getHouseNumber(), dtoHuman.getDtoAddress().getStreet(),
                dtoHuman.getDtoAddress().getApartmentNumber(), dtoHuman.getDtoAddress().getTown(), dtoHuman.getDtoAddress().getCountry());
        return human;
    }

    public DtoHuman convert(Human human) {
        DtoHuman dtoHuman;
        dtoHuman = new DtoHuman(human.getId(),human.getName(), human.getBirthDate().getYear(), human.getBirthDate().getMonth(), human.getBirthDate().getDate(),
                human.getAddress().getHouseNumber(), human.getAddress().getStreet(), human.getAddress().getApartmentNumber(),
                human.getAddress().getTown(), human.getAddress().getCountry());
        return dtoHuman;
    }

    public Human[] convertMas(DtoHuman[] dtoHumans) {
        Human humans[] = new Human[dtoHumans.length];
        for (int i = 0; i < dtoHumans.length; i++) {
            humans[i] = new Human(dtoHumans[i].getId(),dtoHumans[i].getName(), dtoHumans[i].getBirthDate().getYear(), dtoHumans[i].getBirthDate().getMonth(),
                    dtoHumans[i].getBirthDate().getDate(), dtoHumans[i].getDtoAddress().getHouseNumber(), dtoHumans[i].getDtoAddress().getStreet(),
                    dtoHumans[i].getDtoAddress().getApartmentNumber(), dtoHumans[i].getDtoAddress().getTown(), dtoHumans[i].getDtoAddress().getCountry());
        }
        return humans;
    }

    public DtoHuman[] convertMas(Human[] humans) {
        DtoHuman dtoHumans[] = new DtoHuman[humans.length];
        for (int i = 0; i < humans.length; i++) {
            dtoHumans[i] = new DtoHuman(humans[i].getId(),humans[i].getName(), humans[i].getBirthDate().getYear(), humans[i].getBirthDate().getMonth(),
                    humans[i].getBirthDate().getDate(), humans[i].getAddress().getHouseNumber(), humans[i].getAddress().getStreet(),
                    humans[i].getAddress().getApartmentNumber(), humans[i].getAddress().getTown(), humans[i].getAddress().getCountry());
        }
        return dtoHumans;
    }
}
