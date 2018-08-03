package com.realestateapp.realestateapp.services;

import com.realestateapp.realestateapp.models.Post;
import org.springframework.stereotype.Service;
import com.realestateapp.realestateapp.repositories.base.PostRepository;
import com.realestateapp.realestateapp.services.base.PostService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Post> findAll() {
        return repository.findAll();
    }

    @Override
    public Post findById(long id) {
        return repository.findById(id);
    }

    @Override
    public void create(Post post) {
        repository.create(post);
    }

    @Override
    public void update(Post ad) {
        repository.update(ad);
    }

    @Override
    public void deleteById(long id) throws Exception {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    //TODO Find the latest five, not in the repository. Here is the logic
    @Override
    public List<Post> findLatest5() {
        List<Post> latestFive = repository.findAll().stream().limit(5).collect(Collectors.toList());
        return latestFive;
    }
}