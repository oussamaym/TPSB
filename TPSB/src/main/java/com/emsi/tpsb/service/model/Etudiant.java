package com.emsi.tpsb.service.model;
import java.io.Serializable;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Etudiant implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idEtudiant;
    private String name;
    private String cin;
    private String level;
}