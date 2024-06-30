package com.tlba.tregueux.Repo;

import com.tlba.tregueux.entities.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface JoueurRepo extends JpaRepository<Joueur, Long> {

    Joueur findByNom(String nom);


    List<Joueur> findByEquipesId(long id);
}
