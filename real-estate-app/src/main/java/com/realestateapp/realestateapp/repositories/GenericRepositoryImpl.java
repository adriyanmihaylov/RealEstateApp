package com.realestateapp.realestateapp.repositories;

import com.realestateapp.realestateapp.models.User;
import com.realestateapp.realestateapp.repositories.base.GenericRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class GenericRepositoryImpl<T> implements GenericRepository<T> {
    private SessionFactory factory;

    public GenericRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public List<T> listAll(String table){
            List<T> generic = new ArrayList<>();
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                generic= session.createQuery("FROM" + table).list();
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return generic;
    }

    @Override
    public T findById(int id, String table) {
        return null;
    }

    @Override
    public void create(T restaurant) {

    }

    @Override
    public void update(int id, T restaurant) {

    }

    @Override
    public void delete(int id) {

    }
}
