package Sevryugin;

public interface MetodsForBD<T, V> {
    public V getEntity(int i) throws EntityNotFound;

    public V[] getAllEntity();

    public void saveEntity(V entity);

    public void saveAllEntity(V[] entitys);
}
