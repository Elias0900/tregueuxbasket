package com.tlba.tregueux.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tlba.tregueux.DTO.JoueurDTO;
import com.tlba.tregueux.Service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tlba.tregueux.Exception.JoueurException;

import java.util.List;

@RestController
@RequestMapping("api/joueur")
public class JoueurController {
    @Autowired
    private JoueurService service;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(consumes = "application/json", produces = "application/json")
    private ResponseEntity<JoueurDTO> newJoueur(@RequestBody JoueurDTO jDto) throws Exception {
        JoueurDTO joueurDTO = service.saveOrUpdate(jDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(joueurDTO);
    }


    @GetMapping
    private ResponseEntity<List<JoueurDTO>> tousLesJoueurs() {
        List<JoueurDTO> joueurDTOList = service.getAll();
        return new ResponseEntity<>(joueurDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/equipe/{id}")
    private ResponseEntity<List<JoueurDTO>> joueurParTeam(@PathVariable("id") long id) {
        List<JoueurDTO> joueurDTOList = service.getByTeamId(id);
        return new ResponseEntity<>(joueurDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    private ResponseEntity<JoueurDTO> findById(@PathVariable("id") long id) throws Exception {
        JoueurDTO joueurDTOList = service.findById(id);
        return new ResponseEntity<>(joueurDTOList, HttpStatus.OK);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    private ResponseEntity<JoueurDTO> modifierJoueur(@RequestBody JoueurDTO jDto) throws Exception {
        return new ResponseEntity<>(service.update(jDto), HttpStatus.OK);

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Long> suppression(@PathVariable("id") long id) {
        service.suppressionJoueur(id);
        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

}