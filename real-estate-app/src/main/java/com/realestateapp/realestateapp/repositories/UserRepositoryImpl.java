package com.realestateapp.realestateapp.repositories;

import com.realestateapp.realestateapp.models.Role;
import com.realestateapp.realestateapp.repositories.base.RoleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public User getById(int id) {
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
    public User getByUsername(String name) {
        List<User> users = new ArrayList<>();
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            String query = String.format("FROM User u WHERE u.username LIKE '%s'", name);
            users = session.createQuery(query).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public User getByEmail(String email) {
        List<User> users = new ArrayList<>();
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            String query = String.format("FROM User u WHERE u.email LIKE '%s'", email);
            users = session.createQuery(query).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public boolean create(User user) {
        List<User> allUsers = getAll();

        if (allUsers.contains(user)) {
            System.out.println("Failed to create new user! Username: " + user.getUsername());
            return false;
        }

        try (Session session = factory.openSession()) {
            Role role = new Role("USER");
            role.setId(2);
            user.setRole(role);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

            System.out.println("CREATED User Id: " + user.getId() + " username:" + user.getUsername());
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
                System.out.println("UPDATED: User: " + user.getUsername());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Failed to update user!");
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        User user = getById(id);
        if (user != null) {
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                session.delete(user);
                session.getTransaction().commit();
                System.out.println("DELETED User Id:" + user.getId() + " username: " + user.getUsername());

                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("User with id: " + id + " wasn't found!");
        return false;
    }
}