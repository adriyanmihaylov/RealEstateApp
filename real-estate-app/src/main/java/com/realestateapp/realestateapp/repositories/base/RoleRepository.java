package com.realestateapp.realestateapp.repositories.base;

import com.realestateapp.realestateapp.models.Role;

public interface RoleRepository {
    Role getById(int id);

    Role getByUserRole(String userRole);
}
