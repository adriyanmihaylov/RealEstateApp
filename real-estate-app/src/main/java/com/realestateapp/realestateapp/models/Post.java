package com.realestateapp.realestateapp.models;

import com.sun.xml.internal.bind.v2.TODO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

//TODO add user functionality

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User author;

    public Post() {

    }

    public Post(String title, String description, User author) {
        setTitle(title);
        setDescription(description);
        setDate(new Date());
        this.author = author;
        author.addUserAds(this);
    }
    public Post(String title, String description) {
        setTitle(title);
        setDescription(description);
        setDate(new Date());

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //TODO:NOT WORKING WITH USERS
//
//    public User getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date = new Date();

    @Override
    public String toString() {
        return "Ad:" +
                "id= " + id +
                ", title= " + title +
                ", description= " + description +
                ", date= " + date +
                "date = " + getDate();

    }

    public void setAuthor(User author) {
        this.author = author;
    }
}