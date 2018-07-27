package realEstateApp.models;


import javax.persistence.*;
import javax.xml.ws.soap.Addressing;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String passwordHash;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;

//    @OneToMany(mappedBy = "author")
//    private Set<Ads> userAds = new HashSet<>();

    public User() {
    }

    public User(String username, String firstName, String lastName, String passwordHash) {
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        setPasswordHash(passwordHash);
    }

    public int getId() {
        return id;
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

//    public Set<Ads> getUserAds() {
//        return userAds;
//    }

//    public void setUserAds(Set<Ads> userAds) {
//        this.userAds = userAds;
//    }

    @Override
    public String toString() {
        return "User: " +
                "id=" + id +
                ", username= " + username +
                ", passwordHash=" + passwordHash +
                ", fullName=" + firstName + " " + lastName;
    }
}