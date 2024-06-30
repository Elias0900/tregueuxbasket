package com.tlba.tregueux.Service;

import org.tlba.DTO.TeamDTO;

import java.util.List;


public interface TeamService {
    List<TeamDTO> getAll();

    TeamDTO saveOrUpdate(TeamDTO t) throws Exception;

    TeamDTO update(TeamDTO t) throws Exception;

    TeamDTO findById(long id) throws Exception;

    TeamDTO findByName(String nom) throws Exception;

    void suppressionTeam(long id);

}
