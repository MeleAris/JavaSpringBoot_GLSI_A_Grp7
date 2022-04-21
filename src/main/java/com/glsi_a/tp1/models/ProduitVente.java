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
    ProduitVenteKey id;

    @ManyToOne
    @MapsId("produit_id")
    @JoinColumn(name = "produit_id")
    Produit produit;

    @ManyToOne
    @MapsId("vente_id")
    @JoinColumn(name = "vente_id")
    Vente vente;

    int quantite;
}
