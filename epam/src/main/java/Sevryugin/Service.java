package Sevryugin;

import lombok.Data;

import java.util.LinkedList;
@Data
public class Service implements MetodsForBD<Human,DtoHuman>{
    protected LinkedList<Human> humans = new LinkedList<>();
    public static void main(String[] args){
        Convertor convertor = new Convertor();
        DtoHuman dtoHuman = new DtoHuman();
        DtoHuman []dtoHumens = new DtoHuman[5];
        for(int i=0;i<dtoHumens.length;i++) {
            dtoHumens[i] = dtoHuman.createRandomDtoHuman();
            System.out.println(dtoHumens[i]);
        }
        // объект класса Service
        Service service =new Service();
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
        dtoHuman = convertor.convert(human);
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
            dtoHuman[i] = convertor.convert(human[i]);
            System.out.println(dtoHuman[i]);
        }
        // dtoHuman = convertor.convertMas(human);

        return dtoHuman;
    }

    public void saveEntity(DtoHuman entity) {
        Convertor convertor =new Convertor();
        Human human = convertor.convert(entity);
        System.out.println("сохранение одной сущности");
        System.out.println(human);
        humans.add(human);
    }

    public void saveAllEntity(DtoHuman[] entitys) {
        Convertor convertor =new Convertor();
        System.out.println("сохранение ввсех сущностей");
        for(int i=0;i<entitys.length;i++){
            humans.add(convertor.convert(entitys[i]));
            System.out.println(convertor.convert(entitys[i]));
        }
    }
}
