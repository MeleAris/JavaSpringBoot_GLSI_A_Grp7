package com.glsi_a.tp1.service;

import com.glsi_a.tp1.models.Vente;
import com.glsi_a.tp1.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenteService {
    @Autowired
    private VenteRepository venteRepository;

    //Création d'un nouveau produit
    public void saveVente(Vente vente)
    {
        venteRepository.save(vente);
    }

    //Affichage de tous les produits
    public List<Vente> showAllVente()
    {
        return venteRepository.findAll();
    }

    //Selection d'un seul produit
    public Vente selectedVente(int id)
    {
        Optional<Vente> optional = venteRepository.findById(id);
        Vente vente = null;
        if (optional.isPresent())
        {
            vente = optional.get();
        }
        else {
            throw new RuntimeException("Id introuvable");
        }
        return vente;
    }

    //Supprimer un produit
    public void deleteVente(int id)
    {
        if (venteRepository.findById(id).isPresent())
        {
            venteRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Impossible de supprimer cet élément");
        }
    }

    //Compter produits en rupture de stock
    public double montantVente(int idv){ return venteRepository.montantVente(idv);}

    //Compter produits en rupture de stock
    public void majmontantVente(int idv){ venteRepository.majmontantVente(idv, montantVente(idv));}

    public long countVente(){ return venteRepository.countVente();}
}

