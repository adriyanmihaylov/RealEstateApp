package realEstateApp.models;

import javax.persistence.*;

@Entity
@Table(name = "materials")
public class Materials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Materials(String name) {
        this.name = name;
    }
    public Materials(){}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Id: %n name: %s", id, getName());
    }
}
