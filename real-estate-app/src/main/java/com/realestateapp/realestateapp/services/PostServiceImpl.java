package com.realestateapp.realestateapp.services;

import com.realestateapp.realestateapp.models.Post;
import org.springframework.stereotype.Service;
import com.realestateapp.realestateapp.repositories.base.PostRepository;
import com.realestateapp.realestateapp.services.base.PostService;

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
    public boolean deleteById(long id) throws Exception {
        return repository.deleteById(id);
    }

    //TODO Find the latest five, not in the repository. Here is the logic
    @Override
    public List<Post> findLatest5() {
        List<Post> latestFive = repository.getAll();
        return latestFive;
    }
}