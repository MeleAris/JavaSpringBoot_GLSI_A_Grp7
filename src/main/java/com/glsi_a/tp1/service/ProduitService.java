package com.glsi_a.tp1.service;

import com.glsi_a.tp1.models.Produit;
import com.glsi_a.tp1.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    //Création d'un nouveau produit
    public void saveProduit(Produit produit)
    {
        produitRepository.save(produit);
    }

    //Affichage de tous les produits
    public List<Produit> showAllProduit()
    {
        return produitRepository.findAll();
    }

    //Selection d'un seul produit
    public Produit selectedProduit(int id) {
        Optional<Produit> optional = produitRepository.findById(id);
        Produit produit = null;
        if (optional.isPresent())
        {
            produit = optional.get();
        }
        else {
            throw new RuntimeException("Id introuvable");
        }
        return produit;
    }

    //Supprimer un produit
    public void deleteProduit(int id) {
        if (produitRepository.findById(id).isPresent())
        {
            produitRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Impossible de supprimer cet élément");
        }
    }

    //Mise à jour quantite d'un produit après approvisionnement
    public void majQteProduit(int id, int quantite)
    {
        produitRepository.majProduit(id, quantite);
    }

    //Liste des produits en stock
    public List<Produit> listProduit(){ return produitRepository.listStockProduit();}

    //Recherche d'un produit à partir de son nom
    public List<Produit> fProduit(String nom){ return produitRepository.findProduit(nom);}

    //Compter tous les produits
    public long countAllProduit(){ return produitRepository.count();}

    //Compter produits en stock
    public long countProduit(){ return produitRepository.countProduit();}

    //Compter produits en rupture de stock
    public long countProduitRupture(){ return produitRepository.countRuptureProduit();}

    //Liste des produits en rupture de stock
    public List<Produit> listRuptureProduit(){ return produitRepository.listRuptureProduit();}

    //Mise à jour quantite d'un produit après vente
    public void majQteProduitVente(int id, int quantite)
    {
        produitRepository.majProduitVente(id, quantite);
    }
}
