package Sevryugin;

import java.util.ArrayList;
import java.util.LinkedList;

public interface MetodsForBD<T,V> {
    public V getEntity(int i);
    public V[] getAllEntity();
    public void saveEntity(V entity);
    public void saveAllEntity(V[] entitys);
}
