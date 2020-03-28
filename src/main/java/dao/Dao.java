package dao;

import java.util.List;
import java.util.Optional;

public interface Dao<A> {
    List<A> getAll();

    Optional<A> get(A a) ;

    Optional<A> getById(int id) ;

    boolean save(A a);

    boolean delete(int id);

    A update(A a);


    void loadData();
}
