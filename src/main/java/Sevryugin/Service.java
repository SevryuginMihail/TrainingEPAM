package Sevryugin;

import lombok.Data;

import java.util.LinkedList;

import static java.lang.Math.random;

@Data
public class Service implements MetodsForBD<Human,DtoHuman>{
    private LinkedList<Human> humans = new LinkedList<Human>();
    public static void main(String[] args){
        Service service = new Service();
        DtoHuman []dtoHumens = new DtoHuman[5];
        for(int i=0;i<dtoHumens.length;i++) {
            dtoHumens[i] = service.createRandomDtoHuman(i+1);
            System.out.println(dtoHumens[i]);
        }
        // добавление одной сущности
        service.saveEntity(dtoHumens[0]);
        // вывод одной сущности
        System.out.println(service.getEntity(0));
        // добавление списка сущностей
        service.saveAllEntity(dtoHumens);
        // вывод всех сущностей
        service.getAllEntity();
    }
    public DtoHuman getEntity(int i) {
        System.out.println("получение одной сущности");
        Convertor convertor =new Convertor();
        DtoHuman dtoHuman;
        Human human = humans.get(i);
        dtoHuman = convertor.convertToDtoHuman(human);
        return dtoHuman;
    }

    public DtoHuman[] getAllEntity() {
        System.out.println("вывод всех сущностей");
        Convertor convertor =new Convertor();
        Human human[] = new Human[humans.size()];
        for(int i=0;i<humans.size();i++)
            human[i]=humans.get(i);
        DtoHuman dtoHuman[]= new DtoHuman[humans.size()];
        for(int i=0;i<humans.size();i++) {
            dtoHuman[i] = convertor.convertToDtoHuman(human[i]);
            System.out.println(dtoHuman[i]);
        }
        return dtoHuman;
    }

    public void saveEntity(DtoHuman entity) {
        Convertor convertor =new Convertor();
        Human human = convertor.convertToHuman(entity);
        System.out.println("сохранение одной сущности");
        System.out.println(human);
        humans.add(human);
    }

    public void saveAllEntity(DtoHuman[] entitys) {
        Convertor convertor =new Convertor();
        System.out.println("сохранение ввсех сущностей");
        for(int i=0;i<entitys.length;i++){
            humans.add(convertor.convertToHuman(entitys[i]));
            System.out.println(convertor.convertToHuman(entitys[i]));
        }
    }
    public DtoHuman createRandomDtoHuman(int id) {
        String nameRandom[] = {"Василий", "Петр", "Кирилл", "Алексей", "Роман", "Тихон","Герман"};// случайное имя
        Integer yearRandom = 1800 + (int) (random() * 220);
        Integer monthRandom = 1 + (int) (random() * 11);
        Integer dateRandom = 1 +(int)(random()*28);
        Integer houseNumberRandom = 1 + (int)(random()*1000);
        String streetRandom[]={"Арбат","Фонтанка","Центральная","Молодежная","Школьная","Лесная","Садовая","Безымянная"};
        Integer apartmentNumberRandom = 1 + (int)(random()*1000);
        String townRandom[]={"Москва","Челябинск","Северодвинск","Одесса","Екатеринбург","Новосибирск","Караганда"};
        String country = "Россия";
        DtoHuman dtoHuman = new DtoHuman(id,nameRandom[(int)(random()*nameRandom.length)],yearRandom,monthRandom,dateRandom,
                houseNumberRandom,streetRandom[(int)(random()*streetRandom.length)],apartmentNumberRandom,
                townRandom[(int)(random()*townRandom.length)],country);
        return dtoHuman;
    }
}
