package com.glsi_a.tp1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Approvisionnement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int quantite;
    private LocalDate dateApp;

    @ManyToOne
    @JoinColumn(name = "approId", nullable = false, insertable = false, updatable = false)
    private Approvisionnement approvisionnement;
    private int approId;
}
