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
public class LigneVente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "produitId", nullable = false, insertable = false, updatable = false)
    private Produit produit;
    private int produitId;

    @ManyToOne
    @JoinColumn(name = "venteId", nullable = false, insertable = false, updatable = false)
    private Vente vente;
    private int venteId;

}


