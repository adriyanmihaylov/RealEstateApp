package com.realestateapp.realestateapp.repositories.base;

import com.realestateapp.realestateapp.models.Role;
import com.realestateapp.realestateapp.models.User;

public interface RoleRepository {
    Role getById(int id);

    Role getByUserRole(String userRole);
}
