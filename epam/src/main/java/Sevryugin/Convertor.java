package Sevryugin;

import lombok.Data;

import java.lang.reflect.Field;

@Data
public class Convertor<T, V> {
    public void convert(T object) throws ClassNotFoundException {
        V v = (V) new Object();
        T t = (T) new Object();
        String c = v.getClass().getName();
        Class clazz = object.getClass();
        System.out.println(c);
    for(Field field : clazz.getDeclaredFields())
        System.out.println(field);
        //return v;
    }
}
