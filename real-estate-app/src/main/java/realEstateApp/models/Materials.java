package realEstateApp.models;

import javax.persistence.*;

@Entity
@Table(name = "Materials")
public class Materials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMaterials")
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
        return String.format("Material: %s", getName());
    }
}
