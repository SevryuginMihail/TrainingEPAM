package Sevryugin;

/**
 * Интерфейс для работы с псевдо базой данных
 *
 * @param <T> - тип хранимой сущности в псевдо базе данных
 * @param <V> - тип dto сущности для вывода из псевдо базы данных
 */
public interface MetodsForBD<T, V> {
    public V getEntity(int i) throws EntityNotFound;

    public V[] getAllEntity();

    public void saveEntity(V entity);

    public void saveAllEntity(V[] entitys);
}
