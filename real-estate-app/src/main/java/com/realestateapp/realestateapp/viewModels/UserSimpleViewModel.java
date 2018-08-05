package com.realestateapp.realestateapp.viewModels;

import com.realestateapp.realestateapp.models.User;

public class UserSimpleViewModel {
    public long id;

    public String username;

    public String firstName;

    public String lastName;

    public String email;

    public static UserSimpleViewModel fromModel(User user) {
        UserSimpleViewModel vm = new UserSimpleViewModel();
        vm.id = user.getId();
        vm.username = user.getUsername();
        vm.firstName = user.getFirstName();
        vm.lastName = user.getLastName();
        vm.email = user.getEmail();

        return vm;
    }
}
