package com.realestateapp.realestateapp.repositories;

import javassist.NotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.stereotype.Repository;
import com.realestateapp.realestateapp.models.User;
import com.realestateapp.realestateapp.repositories.base.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private SessionFactory factory;

    public UserRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            users = session.createQuery("FROM User").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User findById(Long id) {
        User user = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean create(User user) {
        List<User> allUsers = getAll();

        if (allUsers.contains(user)) {
            System.out.println("Failed to create new user! Username: " + user.getUsername());
            return false;
        }

        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

            System.out.println("User: " + user.getUsername() + " created successfully!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(User user) {
        if (user != null) {
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                session.update(user);
                session.getTransaction().commit();
                System.out.println("User: " + user.getUsername() + " updated successfully");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Failed to update user!");
        return false;
    }

    @Override
    public boolean deleteById(long id) {
        User user = findById(id);
        if (user != null) {
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                session.delete(user);
                session.getTransaction().commit();
                System.out.println("User id: " + user.getId() + " username: " + user.getUsername() + " was successfully deleted!");

                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("User with id: " + id + " was not deleted!");
        return false;
    }
}