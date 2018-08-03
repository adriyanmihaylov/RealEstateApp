package com.realestateapp.realestateapp.models;

import javax.persistence.*;

@Entity
@Table(name = "Material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;

    public Material(String name) {
        this.name = name;
    }
    public Material(){}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Material: %s", getName());
    }
}
