package com.realestateapp.realestateapp.models;

import javax.persistence.*;

@Entity
@Table(name = "Types")
public class Types {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "name")
    private String name;

    public Types(String name) {
        this.name = name;
    }
    public Types(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Type: %s", getName());
    }
}
