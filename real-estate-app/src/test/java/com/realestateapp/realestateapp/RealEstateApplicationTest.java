package com.realestateapp.realestateapp;

import com.realestateapp.realestateapp.models.User;
import com.realestateapp.realestateapp.services.base.PropertiesService;
import com.realestateapp.realestateapp.services.base.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.NotNull;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RealEstateApplicationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PropertiesService propertiesService;

//    @Before
//    public void initOb() {
//        User newUser = new User("yani","123456","yani@realestate.com","Yani","Drenchev");
//        userService.create(newUser);
//    }

    @Test
    public void testUser() {
        User user = userService.getByUsername("yani");
        assertNotNull(user.getUsername(), equals("yani"));
    }
}
