package com.realestateapp.realestateapp.models;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAddresses")
    private long id;

    @Column(name = "name")
    private String name;

    public Address(String name) {
        this.name = name;
    }
    public Address(){}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
