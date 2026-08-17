package sn.esmt.inscription.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Inscription {

    private Long id;
    private String nom;
    private String prenom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateNaissance;

    private String telephone;
    private String typeEvenement;

    public Inscription() {
    }

    public Inscription(Long id, String nom, String prenom, LocalDate dateNaissance,
                        String telephone, String typeEvenement) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.typeEvenement = typeEvenement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTypeEvenement() {
        return typeEvenement;
    }

    public void setTypeEvenement(String typeEvenement) {
        this.typeEvenement = typeEvenement;
    }
}
