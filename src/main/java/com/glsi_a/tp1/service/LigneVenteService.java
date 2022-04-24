package com.glsi_a.tp1.service;

import com.glsi_a.tp1.models.LigneVente;
import com.glsi_a.tp1.models.Produit;
import com.glsi_a.tp1.repository.LigneVenteRepository;
import com.glsi_a.tp1.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneVenteService {
    @Autowired
    private LigneVenteRepository ligneVenteRepository;
    @Autowired
    private ProduitRepository produitRepository;

    //Création d'une ligne de vente
    public void saveLigneVente(LigneVente ligneVente)
    {

        Produit produit = ligneVente.getProduit();
        // Vérifier si la qte de produits à vendre est < à celle en stock dans les produits

        if (ligneVente.getQuantite()>produit.getQteStock())
        {
             throw new RuntimeException("produits insuffisants");
        }
        else {
            ligneVenteRepository.save(ligneVente);

            // Vérifier la qte de produits restants après vente et la stocker dans les produits( maj de la qte des produits après vente )

            produit.setQteStock(produit.getQteStock()- ligneVente.getQuantite());
            produitRepository.save(produit);
        }


    }

    //Affichage des lignes de vente
    public List<LigneVente> showAllLigneVente()
    {
        return ligneVenteRepository.findAll();
    }

    //Selection d'une ligne de vente
    public LigneVente selectedLigneVente(int id)
    {
        Optional<LigneVente> optional = ligneVenteRepository.findById(id);
        LigneVente ligneVente = null;
        if (optional.isPresent())
        {
            ligneVente = optional.get();
        }
        else {
            throw new RuntimeException("Id introuvable");
        }
        return ligneVente;
    }

    //Supprimer une ligne de vente
    public void deleteLigneVente(int id)
    {
        if (ligneVenteRepository.findById(id).isPresent())
        {
            ligneVenteRepository.deleteById(id);
            Optional<LigneVente> OpligneVente = ligneVenteRepository.findById(id);
            LigneVente ligneVente = OpligneVente.get();
            Produit produit = ligneVente.getProduit();
            if (ligneVente.getQuantite()>produit.getQteStock())
            {
                throw new RuntimeException("produits insuffisants");
            }
            else {

                // Vérifier la qte de produits restants après vente et la stocker dans les produits( maj de la qte des produits après vente )

                produit.setQteStock(produit.getQteStock()+ ligneVente.getQuantite());
                produitRepository.save(produit);
            }
        }
        else {
            throw new RuntimeException("Impossible de supprimer cet élément");
        }
    }

}


