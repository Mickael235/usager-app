package fr.usager.dto;

import java.util.List;

public class TrainDTO {

    private String matricule;
    private List<Object> wagons;

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public List<Object> getWagons() {
        return wagons;
    }

    public void setWagons(List<Object> wagons) {
        this.wagons = wagons;
    }
}
