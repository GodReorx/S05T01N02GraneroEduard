package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "flowers")
public class FlowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pk_FlowerID;
    @Column(name = "name")
    private String flowerName;
    @Column(name = "country")
    private String flowerCountry;

    public FlowerEntity(){}

    public FlowerEntity(Integer pk_FlowerID, String flowerName, String flowerCountry) {
        this.pk_FlowerID = pk_FlowerID;
        this.flowerName = flowerName;
        this.flowerCountry = flowerCountry;
    }

    public Integer getPk_FlowerID() {
        return pk_FlowerID;
    }

    public void setPk_FlowerID(Integer pk_FlowerID) {
        this.pk_FlowerID = pk_FlowerID;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getFlowerCountry() {
        return flowerCountry;
    }

    public void setFlowerCountry(String flowerCountry) {
        this.flowerCountry = flowerCountry;
    }
}
