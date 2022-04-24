package com.glsi_a.tp1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "produits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    private int qteStock;
    private int qteSeuil;
    private double prix;
    private LocalDate dateCreation;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false, insertable = false, updatable = false)
    private Category category;
    private int categoryId;
}
