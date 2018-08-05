package com.realestateapp.realestateapp.services.base;

import com.realestateapp.realestateapp.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    List<Post> findLatest5();

    Post findById(long id);

    boolean create(Post post);

    boolean update(Post post);

    boolean deleteById(long id) throws Exception;
    List<Post> search(String address,String material,
                      String type, int priceFrom, int priceTo, int baths, int bedrooms);
}