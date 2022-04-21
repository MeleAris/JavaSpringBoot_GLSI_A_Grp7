package com.glsi_a.tp1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProduitVenteKey implements Serializable {

        @Column(name = "produit_id")
        int produitId;

        @Column(name = "vente_id")
        int venteId;
}
