package com.emsi.tpsb.service;

import com.emsi.tpsb.service.model.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant getEtudiantById(Integer id);
    List<Etudiant> listEtudiant();
    void saveEtudiant(Etudiant etudiant);
    void deleteEtudiant(Integer id);
}
