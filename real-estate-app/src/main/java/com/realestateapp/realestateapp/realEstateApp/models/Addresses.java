package com.realestateapp.realestateapp.realEstateApp.models;



import javax.persistence.*;

@Entity
@Table(name = "Addresses")
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAddresses")
    private int Id;

    @Column(name = "name")
    private String name;

    public Addresses(String name) {
        this.name = name;
    }
    public Addresses(){}

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
}
