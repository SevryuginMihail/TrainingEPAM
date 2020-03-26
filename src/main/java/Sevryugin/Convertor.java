package Sevryugin;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс реализует конвертацию между сущностями Human и HumanDto
 */
@Data
public class Convertor {
    private Logger consoleLogger = LoggerFactory.getLogger(Convertor.class);

    /**
     * Метод конвертирует объект класса HumanDto в объект класса Human
     *
     * @param dtoHuman - входящий объект HumanDto
     * @return - возвращает объект Human
     */
    public Human convertToHuman(DtoHuman dtoHuman) {
        Human human;
        human = new Human(dtoHuman.getId(), dtoHuman.getName(), dtoHuman.getBirthDate().getYear(), dtoHuman.getBirthDate().getMonth(),
                dtoHuman.getBirthDate().getDate(), dtoHuman.getDtoAddress().getHouseNumber(), dtoHuman.getDtoAddress().getStreet(),
                dtoHuman.getDtoAddress().getApartmentNumber(), dtoHuman.getDtoAddress().getTown(), dtoHuman.getDtoAddress().getCountry());
        consoleLogger.info("конвертация : dtoHuman > Human ; id : " + dtoHuman.getId());
        return human;
    }

    /**
     * Метод конвертирует объект класса Human в объект класса HumanDto
     *
     * @param human - входящий объект класса Human
     * @return - возвращает объект HumanDto
     */
    public DtoHuman convertToDtoHuman(Human human) {
        DtoHuman dtoHuman;
        dtoHuman = new DtoHuman(human.getId(), human.getName(), human.getBirthDate().getYear(), human.getBirthDate().getMonth(), human.getBirthDate().getDate(),
                human.getAddress().getHouseNumber(), human.getAddress().getStreet(), human.getAddress().getApartmentNumber(),
                human.getAddress().getTown(), human.getAddress().getCountry());
        consoleLogger.info("конвертация : Human > dtoHuman ; id : " + human.getId());
        return dtoHuman;
    }
}
