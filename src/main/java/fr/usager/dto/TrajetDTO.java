package fr.usager.dto;

public class TrajetDTO {
    private Integer id;
    private GareDTO gareDepart;
    private GareDTO gareArrivee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GareDTO getGareDepart() {
        return gareDepart;
    }

    public void setGareDepart(GareDTO gareDepart) {
        this.gareDepart = gareDepart;
    }

    public GareDTO getGareArrivee() {
        return gareArrivee;
    }

    public void setGareArrivee(GareDTO gareArrivee) {
        this.gareArrivee = gareArrivee;
    }
}
