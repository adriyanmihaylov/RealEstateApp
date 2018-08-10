package com.realestateapp.realestateapp.services;

import com.realestateapp.realestateapp.models.User;
import com.realestateapp.realestateapp.repositories.base.RoleRepository;
import com.realestateapp.realestateapp.repositories.base.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = this.userRepository.getByUsername(userName);

        if (user == null) {
            System.out.println("Username is  null");
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + user);

        // [ROLE_USER, ROLE_ADMIN,..]
        String role = "ROLE_" + user.getRole();
        List<GrantedAuthority> grantList = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        grantList.add(authority);

        UserDetails userDetails = (UserDetails) new User(user.getUsername(), user.getPassword(), grantList);

        return userDetails;
    }
}
