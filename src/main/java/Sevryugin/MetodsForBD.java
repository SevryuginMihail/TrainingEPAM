package Sevryugin;

public interface MetodsForBD<T1, T2> {
    public T2 getEntity(int i);

    public T2[] getAllEntity();

    public void saveEntity(T2 entity);

    public void saveAllEntity(T2[] entitys);
}
