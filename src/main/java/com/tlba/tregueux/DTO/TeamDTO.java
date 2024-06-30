package com.tlba.tregueux.DTO;

import java.util.Set;

public class TeamDTO {

    private Long id;
    private String name;
    private String categorie;
    private String niveau;
    private String coach;
    private Set<Long> joueurIds; // Pour stocker les identifiants des joueurs dans l'équipe


    public TeamDTO() {
        // Constructeur par défaut
    }

    public TeamDTO(Long id, String name, String categorie, String niveau, String coach, Set<Long> joueurIds) {
        this.id = id;
        this.name = name;
        this.categorie = categorie;
        this.niveau = niveau;
        this.coach = coach;
        this.joueurIds = joueurIds;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Set<Long> getJoueurIds() {
        return joueurIds;
    }

    public void setJoueurIds(Set<Long> joueurIds) {
        this.joueurIds = joueurIds;
    }
}
