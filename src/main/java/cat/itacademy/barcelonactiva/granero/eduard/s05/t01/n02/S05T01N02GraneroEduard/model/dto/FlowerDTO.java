package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n02.S05T01N02GraneroEduard.model.dto;

public class FlowerDTO {
    private Integer pk_FlowerID;
    private String flowerName;
    private String flowerCountry;
    private String flowerType;

    public FlowerDTO(Integer pk_FlowerID, String flowerName, String flowerCountry) {
        this.pk_FlowerID = pk_FlowerID;
        this.flowerName = flowerName;
        this.flowerCountry = flowerCountry;
        this.flowerType = checkCountryUE(flowerCountry);
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

    public String getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
    }

    public static String checkCountryUE(String flowerCountry) {
        for (CountryEU country : CountryEU.values()) {
            if (flowerCountry.equalsIgnoreCase(country.name())) {
                return "EU";
            }
        }
        return "NOT_EU";
    }
}
