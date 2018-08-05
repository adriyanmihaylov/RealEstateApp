package com.realestateapp.realestateapp.services;

import com.realestateapp.realestateapp.models.Post;
import javafx.geometry.Pos;
import org.springframework.stereotype.Service;
import com.realestateapp.realestateapp.repositories.base.PostRepository;
import com.realestateapp.realestateapp.services.base.PostService;

import java.util.ArrayList;
import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    private PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Post> findAll() {
        return repository.getAll();
    }

    @Override
    public Post findById(long id) {
        return repository.findById(id);
    }

    @Override
    public boolean create(Post post) {
        return repository.create(post);
    }

    @Override
    public boolean update(Post ad) {
        return repository.update(ad);
    }

    @Override
    public boolean deleteById(long id) {
        return repository.deleteById(id);
    }

    @Override
    public List<Post> search(String address, String material, String type, int priceFrom, int priceTo, int baths, int bedrooms) {
        return null;
    }

    @Override
    public List<Post> findLatest5() {
        List<Post> all = repository.getAll();
        List<Post> latestFive = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            latestFive.add(all.get(all.size()-i-1));
        }
        return latestFive;
    }

}