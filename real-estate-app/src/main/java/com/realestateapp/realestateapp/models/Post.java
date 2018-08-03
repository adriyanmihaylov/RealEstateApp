package com.realestateapp.realestateapp.models;

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

    public Post() {}

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
}