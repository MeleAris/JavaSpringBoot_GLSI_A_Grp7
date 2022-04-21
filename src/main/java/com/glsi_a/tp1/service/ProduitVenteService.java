package com.glsi_a.tp1.service;

import com.glsi_a.tp1.models.ProduitVente;
import com.glsi_a.tp1.models.ProduitVenteKey;
import com.glsi_a.tp1.models.Vente;
import com.glsi_a.tp1.repository.ProduitVenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitVenteService {

    @Autowired
    private ProduitVenteRepository repository;

    public void save(ProduitVente produitVente)
    {
        repository.save(produitVente);
    }

    public List<ProduitVente> showAll()
    {
        return repository.findAll();
    }

    public ProduitVente selected(ProduitVenteKey id)
    {
        Optional<ProduitVente> optional = repository.findById(id);
        ProduitVente produitVente = null;
        if (optional.isPresent())
        {
            produitVente = optional.get();
        }
        else {
            throw new RuntimeException("Id introuvable");
        }
        return produitVente;
    }

    //Supprimer un produit
    public void delete(ProduitVenteKey id)
    {
        if (repository.findById(id).isPresent())
        {
            repository.deleteById(id);
        }
        else {
            throw new RuntimeException("Impossible de supprimer cet élément");
        }
    }
}
