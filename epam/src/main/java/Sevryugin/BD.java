package Sevryugin;

import lombok.Data;

import java.util.ArrayList;
@Data
public class BD<T>implements MetodsForBD<T>{
    ArrayList<T> humans;

    public T getEntity(int i) {
        return humans.get(i);
    }

    public ArrayList<T> getAllEntity() {
        return humans;
    }

    public void saveEntity(T entity) {
        humans.add(entity);
    }

    public void saveAllEntity(T[] entitys) {
        for(T ent : entitys){
            humans.add(ent);
        }
    }
}
