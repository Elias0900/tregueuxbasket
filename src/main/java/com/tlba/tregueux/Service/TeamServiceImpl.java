package com.tlba.tregueux.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tlba.tregueux.DTO.TeamDTO;
import com.tlba.tregueux.MapperDTO.DtoConvertisseur;
import com.tlba.tregueux.Repo.TeamRepository;
import com.tlba.tregueux.entities.Team;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;


    @Override
    public List<TeamDTO> getAll() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(team -> DtoConvertisseur.convert(team, TeamDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TeamDTO saveOrUpdate(TeamDTO teamDTO) throws Exception {
        Team team = DtoConvertisseur.convert(teamDTO, Team.class);
        Team savedTeam = teamRepository.save(team);
        return DtoConvertisseur.convert(savedTeam, TeamDTO.class);
    }

    @Override
    public TeamDTO update(TeamDTO teamDTO) throws Exception {
        if (teamDTO.getId() == null) {
            throw new IllegalArgumentException("Team id cannot be null for update.");
        }

        Optional<Team> optionalTeam = teamRepository.findById(teamDTO.getId());
        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            team.setName(teamDTO.getName());
            team.setCategorie(teamDTO.getCategorie());
            team.setNiveau(teamDTO.getNiveau());
            team.setCoach(teamDTO.getCoach());

            // Mise à jour des joueurs si nécessaire (à implémenter selon votre logique)

            Team updatedTeam = teamRepository.save(team);
            return DtoConvertisseur.convert(updatedTeam, TeamDTO.class);
        } else {
            throw new Exception("Team not found with id: " + teamDTO.getId());
        }
    }

    @Override
    public TeamDTO findById(long id) throws Exception {
        Optional<Team> optionalTeam = teamRepository.findById(id);
        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            return DtoConvertisseur.convert(team, TeamDTO.class);
        } else {
            throw new Exception("Team not found with id: " + id);
        }
    }

    @Override
    public TeamDTO findByName(String name) throws Exception {
        Optional<Team> optionalTeam = Optional.ofNullable(teamRepository.findByName(name));
        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            return DtoConvertisseur.convert(team, TeamDTO.class);
        } else {
            throw new Exception("Team not found with name: " + name);
        }
    }

    @Override
    public void suppressionTeam(long id) {
        teamRepository.deleteById(id);
    }
}
