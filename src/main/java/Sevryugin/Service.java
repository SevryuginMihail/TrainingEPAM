package Sevryugin;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

import static java.lang.Math.random;

/**
 * Класс реализующий методы доступа к псевдо базе данных
 */
@Data
public class Service implements MetodsForBD<Human, DtoHuman> {
    private LinkedList<Human> humans = new LinkedList<Human>();
    private Logger fileAndConsoleLogger = LoggerFactory.getLogger(Service.class);

    /**
     * Метод возвращает 1 сущность по ее id
     *
     * @param i - номер получаемой сущности
     * @return - возвращает объект класса HumanDto
     * @throws EntityNotFound - сущность не найдена
     */
    public DtoHuman getEntity(int i) throws EntityNotFound {
        System.out.println("получение одной сущности");
        if (i > humans.size()) throw new EntityNotFound("Нет сущности с таким индексом");
        Convertor convertor = new Convertor();
        DtoHuman dtoHuman;
        Human human = humans.get(i);
        dtoHuman = convertor.convertToDtoHuman(human);
        fileAndConsoleLogger.info("Из бд получена сущность, id : " + dtoHuman.getId());
        return dtoHuman;
    }

    /**
     * Метод возвращает все сущности из бд
     *
     * @return - возвращает все сущности из бд
     */
    public DtoHuman[] getAllEntity() {
        System.out.println("вывод всех сущностей");
        Convertor convertor = new Convertor();
        Human human[] = new Human[humans.size()];
        for (int i = 0; i < humans.size(); i++)
            human[i] = humans.get(i);
        DtoHuman dtoHuman[] = new DtoHuman[humans.size()];
        for (int i = 0; i < humans.size(); i++) {
            dtoHuman[i] = convertor.convertToDtoHuman(human[i]);
            System.out.println(dtoHuman[i]);
        }
        return dtoHuman;
    }

    /**
     * Метод добавляет сущность в бд
     *
     * @param entity - передаваемая сущность
     */
    public void saveEntity(DtoHuman entity) {
        Convertor convertor = new Convertor();
        Human human = convertor.convertToHuman(entity);
        fileAndConsoleLogger.info("сохранение сущности , id : " + human.getId());
        System.out.println(human);
        humans.add(human);
    }

    /**
     * Метод передает в бд массив сущностей
     *
     * @param entitys - передаваемые сущности
     */
    public void saveAllEntity(DtoHuman[] entitys) {
        Convertor convertor = new Convertor();
        System.out.println("сохранение всех сущностей");
        for (int i = 0; i < entitys.length; i++) {
            humans.add(convertor.convertToHuman(entitys[i]));
            fileAndConsoleLogger.info("сохранение сущности , id : " + entitys[i].getId());
            System.out.println(convertor.convertToHuman(entitys[i]));
        }
    }

    /**
     * Метод возвращает новую сущность
     *
     * @param id - id сущности
     * @return - созданная сущность
     */
    public DtoHuman createRandomDtoHuman(int id) {
        String nameRandom[] = {"Василий", "Петр", "Кирилл", "Алексей", "Роман", "Тихон", "Герман"};// случайное имя
        Integer yearRandom = 1800 + (int) (random() * 220);
        Integer monthRandom = 1 + (int) (random() * 11);
        Integer dateRandom = 1 + (int) (random() * 28);
        Integer houseNumberRandom = 1 + (int) (random() * 1000);
        String streetRandom[] = {"Арбат", "Фонтанка", "Центральная", "Молодежная", "Школьная", "Лесная", "Садовая", "Безымянная"};
        Integer apartmentNumberRandom = 1 + (int) (random() * 1000);
        String townRandom[] = {"Москва", "Челябинск", "Северодвинск", "Одесса", "Екатеринбург", "Новосибирск", "Караганда"};
        String country = "Россия";
        DtoHuman dtoHuman = new DtoHuman(id, nameRandom[(int) (random() * nameRandom.length)], yearRandom, monthRandom, dateRandom,
                houseNumberRandom, streetRandom[(int) (random() * streetRandom.length)], apartmentNumberRandom,
                townRandom[(int) (random() * townRandom.length)], country);
        return dtoHuman;
    }
}
