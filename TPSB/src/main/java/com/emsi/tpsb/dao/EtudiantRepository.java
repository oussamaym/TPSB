package com.emsi.tpsb.dao;

import java.util.List;

import com.emsi.tpsb.service.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    public Etudiant findByName(String name);

    public List<Etudiant> findByLevel(String level);

    public Etudiant findByCin(String cin);
}
