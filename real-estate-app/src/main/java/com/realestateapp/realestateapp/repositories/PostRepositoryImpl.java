package com.realestateapp.realestateapp.repositories;

import com.realestateapp.realestateapp.models.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.realestateapp.realestateapp.repositories.base.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private static SessionFactory factory;

    public PostRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Post> findAll() {
        List<Post> allPosts = new ArrayList<>();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            allPosts = session.createQuery("from Post").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allPosts;
    }


    @Override
    public Post findById(long id) {
        Post post = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            post = session.get(Post.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return post;
    }

    @Override
    public void create(Post newPost) {
        //TODO Validation
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(newPost);
            session.getTransaction().commit();
            System.out.println("Post was created Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    @Override
    public void update(Post post) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(post);
            session.getTransaction().commit();
            System.out.println("Updated Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Post post = findById(id);
        if (post != null) {
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                session.delete(id);
                session.getTransaction().commit();
                System.out.println("The 'post' was successfully deleted!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("There is no such post!");
            throw new Exception();
        }
    }
}