package com.emsi.tpsb.controllers;

import com.emsi.tpsb.service.IEtudiantService;
import com.emsi.tpsb.service.model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final IEtudiantService etudiantService;

    @Autowired
    public EtudiantController(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.listEtudiant();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Integer id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        return ResponseEntity.ok(etudiant);
    }

    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.saveEtudiant(etudiant);
        return etudiant;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Integer id, @RequestBody Etudiant updatedEtudiant) {
        Etudiant existingEtudiant = etudiantService.getEtudiantById(id);

        existingEtudiant.setName(updatedEtudiant.getName());
        existingEtudiant.setCin(updatedEtudiant.getCin());
        existingEtudiant.setLevel(updatedEtudiant.getLevel());

        etudiantService.saveEtudiant(existingEtudiant);

        return ResponseEntity.ok(existingEtudiant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Integer id) {
        etudiantService.deleteEtudiant(id);
        return ResponseEntity.ok().<Void>build();
    }
}
