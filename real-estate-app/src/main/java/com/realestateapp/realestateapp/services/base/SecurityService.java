package com.realestateapp.realestateapp.services.base;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}