package com.realestateapp.realestateapp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Comparable<User>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String passwordHash;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    //TODO Add this functionality
    @OneToMany(mappedBy = "author",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Post> userAds;

    public User() {
    }

    public User(String username,String password,String email,String firstName, String lastName) {
        setUsername(username);
        setPasswordHash(password);
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        userAds = new HashSet<>();
    }

    public long getId() {
        return this.id;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

<<<<<<< HEAD
    public void addUserAds(Post add) {
        if (!userAds.contains(add)) {
            userAds.add(add);
        }
        else{
            System.out.println("Add already exists for this user");
        }
    }

    public Set<Post> getUserAds() {
        return userAds;
    }

    @Override
    public String toString() {
        return "User: " +
                "id=" + id +
                ", username= " + username +
                ", passwordHash=" + passwordHash +
                ", email=" + email +
                ", fullName=" + firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object object)
    {
        if (object != null && object instanceof User) {
            User user = (User) object;
            return this.getUsername().equals(user.getUsername());
        }

        return false;
    }

    @Override
    public int compareTo(User o) {
        return this.getUsername().compareTo(o.getUsername());
    }
}