package com.realestateapp.realestateapp.models;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Description")
    private String description;

    @Column(name = "Size")
    private int size;

    @Column(name = "Bedrooms")
    private int bedrooms;

    @Column(name = "Baths")
    private int baths;

    @Column(name = "Price")
    private int price;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserID")
    private User author;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaterialID")
    private Material material;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TypeID")
    private Type type;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AddressID")
    private Address address;

//    private List<String> photosUrls;

    public Property() {

    }

    public Property(Type type, String title, String description, int size, int bedrooms, int baths, int price, User author, Material material, Address address) {
        setType(type);
        setTitle(title);
        setDescription(description);
        setSize(size);
        setBaths(baths);
        setBedrooms(bedrooms);
        setPrice(price);
        setAuthor(author);
        setMaterial(material);
        setAddress(address);
        setDate(new Date());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Property{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", size=" + size +
                ", bedrooms=" + bedrooms +
                ", baths=" + baths +
                ", price=" + price +
                ", author=" + author +
                ", material=" + material +
                ", type=" + type +
                ", address=" + address +
                '}';
    }
}