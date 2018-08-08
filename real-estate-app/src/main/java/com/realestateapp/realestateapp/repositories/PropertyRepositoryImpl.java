package com.realestateapp.realestateapp.repositories;

import com.realestateapp.realestateapp.models.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Property findById(long id) {
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
        Property property = findById(id);
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
}