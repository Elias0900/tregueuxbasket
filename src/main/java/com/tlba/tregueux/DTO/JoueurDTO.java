package com.tlba.tregueux.DTO;

import java.util.Set;

public class JoueurDTO {

    private Long id;
    private String nom;
    private String prenom;
    private int age;
    private int numero;
    private Set<Long> equipeIds; // Pour stocker les identifiants des équipes auxquelles le joueur appartient

    // Constructeurs, getters et setters

    public JoueurDTO() {
        // Constructeur par défaut
    }

    public JoueurDTO(Long id, String nom, String prenom, int age, int numero, Set<Long> equipeIds) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.numero = numero;
        this.equipeIds = equipeIds;
    }

    // Getters et setters

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Set<Long> getEquipeIds() {
        return equipeIds;
    }

    public void setEquipeIds(Set<Long> equipeIds) {
        this.equipeIds = equipeIds;
    }
}

