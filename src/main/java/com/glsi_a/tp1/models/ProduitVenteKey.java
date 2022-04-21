package com.glsi_a.tp1.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProduitVenteKey implements Serializable {

        @Column(name = "produit_id")
        Long produit_id;

        @Column(name = "vente_id")
        Long vente_id;
}
