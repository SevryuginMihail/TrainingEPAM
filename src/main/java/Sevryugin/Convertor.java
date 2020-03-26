package Sevryugin;

import lombok.Data;

/**
 * Класс реализует конвертауию между Human и DtoHuman
 */
@Data
public class Convertor {
    /**
     * Метод конвертирует объект класса DtoHuman в объект класса Human
     *
     * @param dtoHuman - объект для конвертации
     * @return - объект класса Human
     */
    public Human convertToHuman(DtoHuman dtoHuman) {
        Human human;
        human = new Human(dtoHuman.getId(), dtoHuman.getName(), dtoHuman.getBirthDate().getYear(), dtoHuman.getBirthDate().getMonth(),
                dtoHuman.getBirthDate().getDate(), dtoHuman.getDtoAddress().getHouseNumber(), dtoHuman.getDtoAddress().getStreet(),
                dtoHuman.getDtoAddress().getApartmentNumber(), dtoHuman.getDtoAddress().getTown(), dtoHuman.getDtoAddress().getCountry());
        return human;
    }

    /**
     * Метод конвертирует объект класса Human в объект класса DtoHuman
     *
     * @param human - объект для конвертации
     * @return - объект класса DtoHuman
     */
    public DtoHuman convertToDtoHuman(Human human) {
        DtoHuman dtoHuman;
        dtoHuman = new DtoHuman(human.getId(), human.getName(), human.getBirthDate().getYear(), human.getBirthDate().getMonth(), human.getBirthDate().getDate(),
                human.getAddress().getHouseNumber(), human.getAddress().getStreet(), human.getAddress().getApartmentNumber(),
                human.getAddress().getTown(), human.getAddress().getCountry());
        return dtoHuman;
    }
}
