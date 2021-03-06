package com.glsi_a.tp1.repository;

import com.glsi_a.tp1.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer > {

}
