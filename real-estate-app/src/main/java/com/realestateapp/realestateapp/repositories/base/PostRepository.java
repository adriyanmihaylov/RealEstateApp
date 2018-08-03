package com.realestateapp.realestateapp.repositories.base;

import com.realestateapp.realestateapp.models.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();

    Post findById(long id);

    void create(Post newAd);

    void update(Post ad);

    void deleteById(long id) throws Exception;
}
