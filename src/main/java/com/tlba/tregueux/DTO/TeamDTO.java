package com.tlba.tregueux.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {

    private Long id;
    private String name;
    private String categorie;
    private String niveau;
    private String coach;
    private Set<Long> joueurIds; // Pour stocker les identifiants des joueurs dans l'équipe


}
