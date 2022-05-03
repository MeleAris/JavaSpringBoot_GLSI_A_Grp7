package com.glsi_a.tp1.repository;

import com.glsi_a.tp1.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer > {

    @Modifying
    @Query(value = "UPDATE produits set qte_stock = qte_stock + :q where id = :i", nativeQuery = true)
    @Transactional
    void majProduit(@Param("i") int id,@Param("q") int quantite);

    @Query(value = "select p from Produit p where p.qteStock > 0")
    List<Produit> listStockProduit();

    @Query(value = "select p from Produit p where p.libelle like %:n%")
    List<Produit> findProduit(@Param("n") String nom);

    @Query(value = "select count(p) from Produit p where p.qteStock > 0")
    long countProduit();

    @Query(value = "select count(p) from Produit p where p.qteStock <= p.qteSeuil")
    long countRuptureProduit();

    @Query(value = "select p from Produit p where p.qteStock <= p.qteSeuil")
    List<Produit> listRuptureProduit();

    @Modifying
    @Query(value = "UPDATE produits set qte_stock = qte_stock - :q where id = :i", nativeQuery = true)
    @Transactional
    void majProduitVente(@Param("i") int id,@Param("q") int quantite);

}
