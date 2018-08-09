package com.realestateapp.realestateapp.repositories;

import com.realestateapp.realestateapp.models.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.realestateapp.realestateapp.repositories.base.PropertyRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertyRepositoryImpl implements PropertyRepository {
    private static SessionFactory factory;

    public PropertyRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Property> getAll() {
        List<Property> allProperties = new ArrayList<>();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            allProperties = session.createQuery("FROM Property").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allProperties;
    }


    @Override
    public Property getById(int id) {
        Property property = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            property = session.get(Property.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return property;
    }

    @Override
    public boolean create(Property newProperty) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(newProperty);
            session.getTransaction().commit();
            System.out.println("CREATED: Property Id:" + newProperty.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while trying to CREATE post!");
        }

        return false;
    }

    @Override
    public boolean update(Property property) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(property);
            session.getTransaction().commit();
            System.out.println("UPDATED: Property Id:"+ property.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while trying to UPDATE property!");
        }

        return false;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        Property property = getById(id);
        if (property != null) {
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                session.delete(id);
                session.getTransaction().commit();
                System.out.println("DELETED: Property Id:"+ property.getId());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Property> find(String address, String material,
                               String type, String priceFrom, String priceTo, String baths, String bedrooms, String size) {
        Session session = factory.openSession();
        session.beginTransaction();
        List<Property> result;
        String querry = String.format("From Property p where " +
                        "p.address.name LIKE '%s' AND p.material.name LIKE '%s'" +
                        " AND p.type.name LIKE '%s' AND p.price >= '%s' AND p.price <= '%s' AND p.baths LIKE '%s' AND p.bedrooms LIKE '%s' AND p.size LIKE '%s'",
                address, material, type, priceFrom, priceTo, baths, bedrooms, size);


        result = session.createQuery(querry).list();
        return result;
    }
}