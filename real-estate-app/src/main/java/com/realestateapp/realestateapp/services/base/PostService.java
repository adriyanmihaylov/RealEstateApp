package com.realestateapp.realestateapp.services.base;

import com.realestateapp.realestateapp.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    List<Post> findLatest5();

    Post findById(long id);

    void create(Post post);

    void update(Post post);

    void deleteById(long id) throws Exception;
}