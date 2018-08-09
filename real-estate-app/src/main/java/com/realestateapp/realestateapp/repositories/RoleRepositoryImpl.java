package com.realestateapp.realestateapp.repositories;

import com.realestateapp.realestateapp.models.Role;
import com.realestateapp.realestateapp.repositories.base.RoleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RoleRepositoryImpl implements RoleRepository {
    @Autowired
    private SessionFactory factory;

    @Override
    public Role getById(int id) {
        Role role = null;

        try (Session session = factory.openSession()) {
            session.beginTransaction();
            role = session.get(Role.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return role;
    }

    @Override
    public Role getByUserRole(String userRole) {
        List<Role> roles = new ArrayList<>();

        try (Session session = factory.openSession()) {
            session.beginTransaction();
            String query = String.format("FROM Role r WHERE r.Role LIKE 's'",userRole);
            roles = session.createQuery(query).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (roles.isEmpty()) {
            return null;
        }

        return roles.get(0);
    }
}