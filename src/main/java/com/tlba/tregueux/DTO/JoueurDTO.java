package com.tlba.tregueux.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoueurDTO {

    private Long id;
    private String nom;
    private String prenom;
    private int age;
    private int numero;
    private Set<Long> equipeIds; // Pour stocker les identifiants des équipes auxquelles le joueur appartient

}

