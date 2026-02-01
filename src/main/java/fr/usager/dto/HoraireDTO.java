package fr.usager.dto;

import java.time.LocalTime;

public class HoraireDTO {
    private Integer id;
    private GareDTO gareDepart;
    private GareDTO gareArrivee;
    private LocalTime heureDepart;
    private LocalTime heureArrivee;
    private TrainDTO train;

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

    public LocalTime getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(LocalTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public LocalTime getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(LocalTime heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public TrainDTO getTrain() {
        return train;
    }

    public void setTrain(TrainDTO train) {
        this.train = train;
    }
}
