package com.realestateapp.realestateapp.repositories;

import com.realestateapp.realestateapp.models.Addresses;
import com.realestateapp.realestateapp.repositories.base.AddressesRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class AddressesRepositoryImpl<T> implements AddressesRepository {
    private SessionFactory factory;
    AddressesRepositoryImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<Addresses> listAll() {
        List<Addresses> allAddresses = new ArrayList<>();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            allAddresses= session.createQuery("FROM Addresses").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allAddresses;
    }

    @Override
    public Addresses findById(int id) {
        Addresses address = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            address = session.get(Addresses.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return address;
    }

    @Override
    public void create(Addresses address) throws Exception {
        //TODO validation
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    public void update(Addresses addresses) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(addresses);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR editing the address a problem in the DB");
        }
        System.out.println("Address updated Successfully");
    }

    @Override
    public void delete(int id) {
        Addresses address = findById(id);
        if (address != null) {
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                session.delete(address);
                session.getTransaction().commit();
                System.out.println("The address was successfully deleted!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("ERROR editing the address a problem in the DB");
    }
}
