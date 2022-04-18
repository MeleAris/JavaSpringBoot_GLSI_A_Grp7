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
    public Produit selectedProduit(int id)
    {
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
    public void deleteProduit(int id)
    {
        if (produitRepository.findById(id).isPresent())
        {
            produitRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Impossible de supprimer cet élément");
        }
    }

    public void majQteProduit(int id, int quantite)
    {
        produitRepository.majProduit(id, quantite);
    }

    public List<Produit> listProduit(){ return produitRepository.selectProduit();}

    public List<Produit> fProduit(String nom){ return produitRepository.findProduit(nom);}
}
