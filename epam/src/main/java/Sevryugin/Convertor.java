package Sevryugin;

import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

@Data
public class Convertor<T, V> {
    public void convert(T t, V v) throws IllegalAccessException {
        System.out.println(t.getClass());
        System.out.println(v.getClass());
        Class classT = t.getClass();
        Field[] fields = classT.getDeclaredFields();
        for(Field field : fields){
            String fieldName = field.getName();
            if(!field.isAccessible()) field.setAccessible(true);
            Object value = field.get(t);// значение поля
            System.out.println(field +"\t -> "+fieldName+"\t -> "+value);
        }
        //return v;
    }
}
