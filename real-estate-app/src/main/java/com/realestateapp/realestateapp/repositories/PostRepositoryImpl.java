package com.realestateapp.realestateapp.repositories;

import com.realestateapp.realestateapp.models.Post;
import com.realestateapp.realestateapp.models.User;
import com.realestateapp.realestateapp.repositories.base.UserRepository;
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
    public List<Post> getAll() {
        List<Post> allPosts = new ArrayList<>();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            allPosts = session.createQuery("FROM Post").list();
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
    public boolean create(Post newPost) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(newPost);
            session.getTransaction().commit();
            System.out.println("CREATED: Post Id:" + newPost.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while trying to CREATE post!");
        }

        return false;
    }

    @Override
    public boolean update(Post post) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(post);
            session.getTransaction().commit();
            System.out.println("UPDATED: Post Id:"+ post.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while trying to UPDATE post!");
        }

        return false;
    }

    @Override
    public boolean deleteById(long id) {
        Post post = findById(id);
        if (post != null) {
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                session.delete(id);
                session.getTransaction().commit();
                System.out.println("DELETED: Post Id:"+ post.getId());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}