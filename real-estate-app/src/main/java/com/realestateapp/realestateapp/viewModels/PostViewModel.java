package com.realestateapp.realestateapp.viewModels;

import com.realestateapp.realestateapp.models.Estate;
import com.realestateapp.realestateapp.models.Post;
import com.realestateapp.realestateapp.models.User;

public class PostViewModel {
    public long id;

    public String title;

    public String description;

    public UserSimpleViewModel author;

    public Estate estate;

   public static PostViewModel fromModel(Post post) {
       PostViewModel vm = new PostViewModel();

       vm.id = post.getId();
       vm.title = post.getTitle();
       vm.description = post.getDescription();
       vm.author = UserSimpleViewModel.fromModel(post.getAuthor());
       vm.estate = post.getEstate();
       return vm;
   }
}
