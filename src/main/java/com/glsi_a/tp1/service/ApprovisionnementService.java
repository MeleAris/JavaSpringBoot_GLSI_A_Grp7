package com.glsi_a.tp1.service;

import com.glsi_a.tp1.models.Approvisionnement;
import com.glsi_a.tp1.models.Produit;
import com.glsi_a.tp1.repository.ApprovisionnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ApprovisionnementService {
    @Autowired
    private ApprovisionnementRepository approvisionnementRepository;

    //Création d'un nouveau produit
    public void saveApprovisionnement(Approvisionnement approvisionnement)
    {
        approvisionnementRepository.save(approvisionnement);
    }

    //Affichage de tous les produits
    public List<Approvisionnement> showAllApprovisionnement()
    {
        return approvisionnementRepository.findAll();
    }


    //Affichage de tous les produits
    public List<Approvisionnement> showAllFiltre(LocalDate d,LocalDate f)
    {
        return approvisionnementRepository.filtreApprov(d,f);
    }

    //Selection d'un seul produit
    public Approvisionnement selectedApprovisionnement(int id)
    {
        Optional<Approvisionnement> optional = approvisionnementRepository.findById(id);
        Approvisionnement approvisionnement = null;
        if (optional.isPresent())
        {
            approvisionnement = optional.get();
        }
        else {
            throw new RuntimeException("Id introuvable");
        }
        return approvisionnement;
    }

    //Supprimer un produit
    public void deleteApprovisionnement(int id)
    {
        if (approvisionnementRepository.findById(id).isPresent())
        {
            approvisionnementRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Impossible de supprimer cet élément");
        }
    }
}
