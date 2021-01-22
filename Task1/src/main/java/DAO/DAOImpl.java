package DAO;

import java.util.Collection;
import java.util.LinkedList;

public interface DAOImpl <T, K> {
    T getObject(K id);
    LinkedList<T> getObjects();
}
