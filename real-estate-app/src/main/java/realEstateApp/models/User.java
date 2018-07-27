package realEstateApp.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String passwordHash;
    private String firstName;
    private String secondName;

    @OneToMany(mappedBy = "author")
    private Set<Ads> userAds = new HashSet<>();

    public User() {
    }

    public User(Long id, String username, String firstName, String secondName) {
        setId(id);
        setUsername(username);
        setFirstName(firstName);
        setSecondName(secondName);
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Set<Ads> getUserAds() {
        return userAds;
    }

    public void setUserAds(Set<Ads> userAds) {
        this.userAds = userAds;
    }

    @Override
    public String toString() {
        return "User: " +
                "id=" + id +
                ", username= " + username +
                ", passwordHash=" + passwordHash +
                ", fullName=" + firstName + " " + secondName;
    }
}