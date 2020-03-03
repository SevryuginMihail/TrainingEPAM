package Sevryugin;

import java.util.ArrayList;

public interface MetodsForBD<T> {
    public T getEntity(int i);// получение значения по индексу
    public ArrayList<T> getAllEntity();// получить все
    public void saveEntity(T entity);// сохранение сущности(доменной)
    public void saveAllEntity(T[] entitys);// сохранение всех сущностей(доменной)
}
