package it.dan.homeWork.WorkWithData.dao;

public abstract class AbstractDAO<T> {

    abstract public void save(T ojbect);

    abstract public T get(Object pk);

    abstract public void update(T object);

    abstract public void delete(Object pk);
}
