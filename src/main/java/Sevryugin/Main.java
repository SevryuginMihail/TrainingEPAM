package Sevryugin;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        DtoHuman []dtoHumens = new DtoHuman[2];
        for(int i=0;i<dtoHumens.length;i++) {
            dtoHumens[i] = service.createRandomDtoHuman(i+1);
            System.out.println(dtoHumens[i]);
        }
        // добавление одной сущности
        service.saveEntity(dtoHumens[0]);
        // вывод одной сущности
        try {
            System.out.println(service.getEntity(0));
        } catch (EntityNotFound entityNotFound) {
            entityNotFound.printStackTrace();
        }
        // добавление списка сущностей
        service.saveAllEntity(dtoHumens);
        // вывод всех сущностей
        service.getAllEntity();
    }
}
