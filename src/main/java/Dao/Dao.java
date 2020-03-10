package Dao;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface Dao<A> {
    List<A> getAll() throws IOException, ClassNotFoundException;
    Optional<A> get(A a) throws IOException, ClassNotFoundException;
    Optional<A> getById(int id) throws IOException, ClassNotFoundException;
    boolean create(A a);
    boolean delete(int id) throws IOException, ClassNotFoundException;
    A update(A a);


}
