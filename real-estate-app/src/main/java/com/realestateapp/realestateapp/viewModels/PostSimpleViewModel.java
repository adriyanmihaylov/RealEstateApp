package com.realestateapp.realestateapp.viewModels;

import com.realestateapp.realestateapp.models.Post;

public class PostSimpleViewModel {
    public long id;

    public String title;

    public String description;

    public static PostSimpleViewModel fromModel(Post post) {
        PostSimpleViewModel vm = new PostSimpleViewModel();

        vm.id = post.getId();
        vm.title = post.getTitle();
        vm.description = post.getDescription();
        return vm;
    }
}
