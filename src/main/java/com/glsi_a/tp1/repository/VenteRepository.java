package com.glsi_a.tp1.repository;

import com.glsi_a.tp1.models.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer > {

    @Query(value = "select sum(pv.quantite * p.prix) from Produit_Vente pv JOIN Produits p on pv.produit_id = p.id " +
            "join Vente v on v.id = pv.vente_id where v.id = :i", nativeQuery = true)
    double montantVente(@Param("i") int idv);

    @Modifying
    @Query(value = "update vente set prixTotal = :j where id= :i", nativeQuery = true)
    @Transactional
    void majmontantVente(@Param("i") int idv, @Param("j") double mnt);

    @Query(value = "select count(v) from Vente v where month (v.dateVente) = :mois")
    long countVente(@Param("mois") int mois);

    @Query(value = "select count(*) from vente v where year(v.date_vente) = :an " +
            "group by month(v.date_vente) ORDER by month(v.date_vente) asc", nativeQuery = true)
    List<Integer> stats(@Param("an") int annee);

    @Query(value = "select month(v.date_vente) from vente v where year(v.date_vente) = :an " +
            "group by month(v.date_vente) ORDER by month(v.date_vente) asc", nativeQuery = true)
    List<Integer> mois(@Param("an") int annee);
}
