package com.glsi_a.tp1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProduitVente {
    @EmbeddedId
    ProduitVenteKey id = new ProduitVenteKey();

    @ManyToOne
    @MapsId("produitId")
    @JoinColumn(name = "produit_id")
    Produit produit;

    @ManyToOne
    @MapsId("venteId")
    @JoinColumn(name = "vente_id")
    Vente vente;

    int quantite;
}
