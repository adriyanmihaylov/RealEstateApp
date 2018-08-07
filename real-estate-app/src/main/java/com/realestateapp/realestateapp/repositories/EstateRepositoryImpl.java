package com.realestateapp.realestateapp.repositories;

import com.realestateapp.realestateapp.models.Address;
import com.realestateapp.realestateapp.models.Estate;
import com.realestateapp.realestateapp.models.Material;
import com.realestateapp.realestateapp.models.Type;
import com.realestateapp.realestateapp.repositories.base.EstateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EstateRepositoryImpl implements EstateRepository {

    private SessionFactory factory;

    public EstateRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Estate> getAll() {
        List<Estate> allEstates = new ArrayList<>();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            allEstates = session.createQuery("FROM Estate ").list();
            for (Estate estate: allEstates) {
                estate.getAddress().getName();
                estate.getMaterial().getName();
                estate.getType().getName();
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allEstates;
    }

    @Override
    public Estate getById(long id) {
        Estate estate = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            estate = session.get(Estate.class, id);
            estate.getAddress().getName();
            estate.getMaterial().getName();
            estate.getType().getName();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return estate;
    }

    @Override
    public boolean create(Estate estate) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            Material material = estate.getMaterial();
            Type type = estate.getType();
            Address address = estate.getAddress();
            session.save(material);
            session.save(address);
            session.save(type);
            session.save(estate);
            session.getTransaction().commit();
            return true;
        }catch (Exception e ){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Estate estate) {
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }


}
