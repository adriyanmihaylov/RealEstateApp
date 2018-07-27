package realEstateApp.models;



import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
