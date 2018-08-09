package com.realestateapp.realestateapp.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Role")
    private String role;

    @OneToMany(mappedBy = "role",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<User> users;

    Role() {}

    public Role(String role) {
        setRole(role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}