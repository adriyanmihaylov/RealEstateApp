package com.realestateapp.realestateapp.models;

import javax.persistence.*;

@Entity
@Table(name = "estates")
public class Estate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "AddressId")
    private Address address;

    @OneToOne(optional = false)
    @JoinColumn(name = "materialId")
    private Material material;

    @OneToOne(optional = false)
    @JoinColumn(name = "TypeID")
    private Type type;

    @Column(name = "price")
    private int price;

    @Column(name = "baths")
    private int baths;

    @Column(name = "bedrooms")
    private int bedrooms;

    @Column(name = "size")
    private int size;

    public Estate() {

    }

    public Estate(Address address, Material material, Type type, int price, int baths, int bedrooms, int size) {
        setAddress(address);
        setMaterial(material);
        setType(type);
        setPrice(price);
        setBaths(baths);
        setBedrooms(bedrooms);
        setSize(size);
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}