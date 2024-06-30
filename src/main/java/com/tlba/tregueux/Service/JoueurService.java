package com.tlba.tregueux.Service;

import org.tlba.DTO.JoueurDTO;

import java.util.List;


public interface JoueurService {


    List<JoueurDTO> getAll();

    JoueurDTO saveOrUpdate(JoueurDTO j) throws Exception;

    JoueurDTO update(JoueurDTO j) throws Exception;

    JoueurDTO findById(long id) throws Exception;

    JoueurDTO findByNom(String nom) throws Exception;

    void suppressionJoueur(long id);

    List<JoueurDTO> getByTeamId(long id);


}
