package com.realestateapp.realestateapp.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Comparable<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @NotNull
    @Column(name = "username",unique = true)
    private String username;

    @Size(min = 6)
    @Column(name = "password")
    private String password;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @NotNull
    @Email
    @Column(name = "email",unique = true)
    private String email;

    @OneToMany(mappedBy = "author",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
       private Set<Property> userProperties;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RoleID")
    private Role role;

    public User() {

    }
    public User(String username, String password, List<GrantedAuthority> grantList) {
    }

    public User(String username,String password,String email) {
        setUsername(username);
        setPassword(password);
        setEmail(email);
    }

    public User(String username, String password, String email, String firstName, String lastName) {
        this(username, password, email);
        setFirstName(firstName);
        setLastName(lastName);
    }
    public User(String username){
        this.username= username;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setUserProperties(Set<Property> userAds) {
        this.userProperties = userAds;
    }

    public Set<Property> getUserProperties() {
        return userProperties;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role roles) {
        this.role = roles;
    }

    @Override
    public String toString() {
        return "User: " +
                "id=" + id +
                ", username= " + username +
                ", password=" + password +
                ", email=" + email +
                ", fullName=" + firstName + " " + lastName +
                ", role= " + this.getRole().getRole();
    }

    @Override
    public boolean equals(Object object) {
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