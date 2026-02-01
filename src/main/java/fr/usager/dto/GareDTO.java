package fr.usager.dto;

public class GareDTO {
    private Integer id_gare;
    private String nom_gare;
    private String ville;
    private Integer nb_quai;

    public Integer getId_gare() {
        return id_gare;
    }

    public void setId_gare(Integer id_gare) {
        this.id_gare = id_gare;
    }

    public String getNom_gare() {
        return nom_gare;
    }

    public void setNom_gare(String nom_gare) {
        this.nom_gare = nom_gare;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getNb_quai() {
        return nb_quai;
    }

    public void setNb_quai(Integer nb_quai) {
        this.nb_quai = nb_quai;
    }
}
