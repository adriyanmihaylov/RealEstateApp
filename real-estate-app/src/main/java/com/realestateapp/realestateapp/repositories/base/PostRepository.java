package com.realestateapp.realestateapp.repositories.base;

import com.realestateapp.realestateapp.models.Post;

import java.util.List;

public interface PostRepository {
    List<Post> getAll();

    Post findById(long id);

    boolean create(Post newAd);

    boolean update(Post ad);

    boolean deleteById(long id);
}
