package com.realestateapp.realestateapp.repositories.base;

import java.util.List;

public interface GenericRepository<T> {
    List<T> listAll(String type);

    T findById(int id, String table);

    void create(T object);

    void update(int id, T object);

    void delete(int id);
}

