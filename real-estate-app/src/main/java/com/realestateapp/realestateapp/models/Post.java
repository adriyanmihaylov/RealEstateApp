package com.realestateapp.realestateapp.models;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Field
    @Column(name = "Title")
    private String title;
    @Field
    @Column(name = "Description")
    private String description;

//TODO add user functionality

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserId")
    private User author;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EstateId")
    private Estate estate;


    public Post() {

    }

    public Post(String title, String description, Estate estate) {
        setTitle(title);
        setDescription(description);
        setDate(new Date());
        setEstate(estate);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Ad:" +
                "id= " + id +
                ", title= " + title +
                ", description= " + description +
                ", date= " + date +
                "date = " + getDate();

    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }
}