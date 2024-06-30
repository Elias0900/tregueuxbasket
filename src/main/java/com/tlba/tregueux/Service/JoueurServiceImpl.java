package com.tlba.tregueux.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tlba.DTO.JoueurDTO;
import org.tlba.MapperDTO.DtoConvertisseur;
import org.tlba.Repo.JoueurRepo;
import org.tlba.entities.Joueur;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class JoueurServiceImpl implements JoueurService {

    @Autowired
    private JoueurRepo joueurRepository;

    @Override
    public List<JoueurDTO> getAll() {
        List<Joueur> joueurs = joueurRepository.findAll();
        return joueurs.stream()
                .map(joueur -> DtoConvertisseur.convert(joueur, JoueurDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public JoueurDTO saveOrUpdate(JoueurDTO joueurDTO) throws Exception {
        Joueur joueur = DtoConvertisseur.convert(joueurDTO, Joueur.class);
        Joueur savedJoueur = joueurRepository.save(joueur);
        return DtoConvertisseur.convert(savedJoueur, JoueurDTO.class);
    }

    @Override
    public JoueurDTO update(JoueurDTO joueurDTO) throws Exception {
        if (joueurDTO.getId() == null) {
            throw new IllegalArgumentException("Joueur id cannot be null for update.");
        }

        Optional<Joueur> optionalJoueur = joueurRepository.findById(joueurDTO.getId());
        if (optionalJoueur.isPresent()) {
            Joueur joueur = optionalJoueur.get();
            joueur.setNom(joueurDTO.getNom());
            joueur.setPrenom(joueurDTO.getPrenom());
            joueur.setAge(joueurDTO.getAge());
            joueur.setNumero(joueurDTO.getNumero());

            // Mise à jour des équipes si nécessaire (à implémenter selon votre logique)

            Joueur updatedJoueur = joueurRepository.save(joueur);
            return DtoConvertisseur.convert(updatedJoueur, JoueurDTO.class);
        } else {
            throw new Exception("Joueur not found with id: " + joueurDTO.getId());
        }
    }

    @Override
    public JoueurDTO findById(long id) throws Exception {
        Optional<Joueur> optionalJoueur = joueurRepository.findById(id);
        if (optionalJoueur.isPresent()) {
            Joueur joueur = optionalJoueur.get();
            return DtoConvertisseur.convert(joueur, JoueurDTO.class);
        } else {
            throw new Exception("Joueur not found with id: " + id);
        }
    }

    @Override
    public JoueurDTO findByNom(String nom) throws Exception {
        Optional<Joueur> optionalJoueur = Optional.ofNullable(joueurRepository.findByNom(nom));
        if (optionalJoueur.isPresent()) {
            Joueur joueur = optionalJoueur.get();
            return DtoConvertisseur.convert(joueur, JoueurDTO.class);
        } else {
            throw new Exception("Joueur not found with nom: " + nom);
        }
    }

    @Override
    public void suppressionJoueur(long id) {
        joueurRepository.deleteById(id);
    }

    @Override
    public List<JoueurDTO> getByTeamId(long id) {
        List<Joueur> joueurs = joueurRepository.findByEquipesId(id);
        return joueurs.stream()
                .map(joueur -> DtoConvertisseur.convert(joueur, JoueurDTO.class))
                .collect(Collectors.toList());
    }
}
