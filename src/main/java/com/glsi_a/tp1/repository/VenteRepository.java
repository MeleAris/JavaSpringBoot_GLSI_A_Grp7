package com.glsi_a.tp1.repository;

import com.glsi_a.tp1.models.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer > {

    @Query(value = "select sum(pv.quantite * p.prix) from Produit_Vente pv JOIN Produits p on pv.produit_id = p.id " +
            "join Vente v on v.id = pv.vente_id where v.id = :i", nativeQuery = true)
    double montantVente(@Param("i") int idv);

    @Modifying
    @Query(value = "update vente set prixTotal = :j where id= :i", nativeQuery = true)
    @Transactional
    void majmontantVente(@Param("i") int idv, @Param("j") double mnt);

}
