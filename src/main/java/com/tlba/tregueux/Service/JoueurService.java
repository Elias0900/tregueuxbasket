package com.tlba.tregueux.Service;

import com.tlba.tregueux.DTO.JoueurDTO;
import com.tlba.tregueux.Exception.JoueurException;

import java.util.List;


public interface JoueurService {


    List<JoueurDTO> getAll();

    JoueurDTO saveOrUpdate(JoueurDTO j) throws JoueurException;

    JoueurDTO update(JoueurDTO j) throws JoueurException;

    JoueurDTO findById(long id) throws JoueurException;

    JoueurDTO findByNom(String nom) throws JoueurException;

    void suppressionJoueur(long id);

    List<JoueurDTO> getByTeamId(long id);


}
