package com.emsi.tpsb.service;

import com.emsi.tpsb.dao.EtudiantRepository;
import com.emsi.tpsb.service.model.Etudiant;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EtudiantServiceImpl implements IEtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiant getEtudiantById(Integer id) {
        Optional<Etudiant> optional = etudiantRepository.findById(id);
        return optional.orElseThrow(() -> new RuntimeException("Etudiant introuvable pour l'id :: " + id));
    }

    @Override
    public List<Etudiant> listEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public void saveEtudiant(Etudiant etudiant) {
        etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(Integer id) {
        try {
            etudiantRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la suppression de l'étudiant avec l'id :: " + id, e);
        }
    }
}
