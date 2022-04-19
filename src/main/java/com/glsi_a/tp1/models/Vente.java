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
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantite;
    private double prixTotal;
    private LocalDate dateVente;

    @ManyToOne
    @JoinColumn(name = "produitId", nullable = false, insertable = false, updatable = false)
    private Produit produit;
    private int produitId;
}

