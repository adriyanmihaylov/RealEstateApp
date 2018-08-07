package com.realestateapp.realestateapp.repositories;

import com.realestateapp.realestateapp.models.Address;
import com.realestateapp.realestateapp.repositories.base.AddressRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressRepositoryImpl<T> implements AddressRepository {
    private SessionFactory factory;

    AddressRepositoryImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<Address> listAll() {
        List<Address> allAddresses = new ArrayList<>();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            allAddresses= session.createQuery("FROM Address").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allAddresses;
    }

    @Override
    public Address findById(long id) {
        Address address = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            address = session.get(Address.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return address;
    }

    @Override
    public void create(Address address) throws Exception {
        //TODO validation

        List<Address> allAddresses = this.listAll();
        if(address != null) {
            for (Address addr: allAddresses) {
                if(addr.getName().equals(address.getName())) {

                }
            }
        }
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    public void update(Address address) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR editing the address a problem in the DB");
        }
        System.out.println("Address updated Successfully");
    }

    @Override
    public void delete(long id) {
        Address address = findById(id);
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