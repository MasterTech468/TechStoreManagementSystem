package techstoreapplication.DAO;

import java.util.List;

public interface DAO <T>{
    boolean add(T t);
    boolean update(T t);
    boolean delete(T t);
    T get(T t);
    List<T> getAll();
}
