package com.glsi_a.tp1.repository;

import com.glsi_a.tp1.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer > {

}
