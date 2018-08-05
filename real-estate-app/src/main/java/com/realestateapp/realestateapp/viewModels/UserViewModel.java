package com.realestateapp.realestateapp.viewModels;

import com.realestateapp.realestateapp.models.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserViewModel {
    public long id;

    public String username;

    public String firstName;

    public String lastName;

    public String email;

    public Set<PostSimpleViewModel> userPosts;

    public static UserViewModel fromModel(User user) {
        UserViewModel vm = new UserViewModel();
        vm.id = user.getId();
        vm.username = user.getUsername();
        vm.firstName = user.getFirstName();
        vm.lastName = user.getLastName();
        vm.email = user.getEmail();
        vm.userPosts = user.getUserPosts()
            .stream()
            .map(PostSimpleViewModel::fromModel)
            .collect(Collectors.toSet());

        return vm;
    }
}
