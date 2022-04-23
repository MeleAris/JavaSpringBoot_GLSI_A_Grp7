package com.glsi_a.tp1.repository;

import com.glsi_a.tp1.models.ProduitVente;
import com.glsi_a.tp1.models.ProduitVenteKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitVenteRepository extends JpaRepository<ProduitVente, ProduitVenteKey> {

}