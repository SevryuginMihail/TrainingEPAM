package Sevryugin;

/**
 * Класс реализует работу по добавлению и получению сущности HumanDto из псевдо базы данных
 */
public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        DtoHuman[] dtoHumens = new DtoHuman[2];
        for (int i = 0; i < dtoHumens.length; i++) {
            dtoHumens[i] = service.createRandomDtoHuman(i + 1);
            System.out.println(dtoHumens[i]);
        }
        service.saveEntity(dtoHumens[0]);
        try {
            System.out.println(service.getEntity(0));
        } catch (EntityNotFound entityNotFound) {
            entityNotFound.printStackTrace();
        }
        service.saveAllEntity(dtoHumens);
        service.getAllEntity();
    }
}
