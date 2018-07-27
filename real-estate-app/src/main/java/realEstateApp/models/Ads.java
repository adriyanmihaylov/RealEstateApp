package realEstateApp.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Ads")
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    //    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private User author;
    public Ads(){

    }

    public Ads( String title, String description, String author) {

        setTitle(title);
        setDescription(description);
//        setAuthor(author);
        setDate(new Date());
    }

    public Long getId() {
        return id;
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

//    public User getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date = new Date();

    @Override
    public String toString() {
        return "Ad: " +
                "id= " + id +
                ", author= " + "author" +
                ", title= " + title +
                ", description= " + description +
                ", date= " + date;
    }
}