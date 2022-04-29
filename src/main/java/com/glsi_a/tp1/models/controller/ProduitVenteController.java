package com.glsi_a.tp1.models.controller;

import com.glsi_a.tp1.models.ProduitVente;
import com.glsi_a.tp1.models.ProduitVenteKey;
import com.glsi_a.tp1.models.Vente;
import com.glsi_a.tp1.service.ProduitService;
import com.glsi_a.tp1.service.ProduitVenteService;
import com.glsi_a.tp1.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/pv")
public class ProduitVenteController {

    @Autowired
    private ProduitService produitService;
    @Autowired
    private ProduitVenteService service;
    @Autowired
    private VenteService venteService;

    //Action quand on va cliquer la première fois sur continuer
    /*@PostMapping("/save")
    public String save(ProduitVente pv)
    {
        Vente vente = new Vente();
        vente.setDateVente(LocalDate.now());
        vente.setPrixTotal(0);
        venteService.saveVente(vente);

        vid = vente.getId();
        pv.setVente(vente);
        service.save(pv);
        produitService.majQteProduitVente(pv.getProduit().getId(), pv.getQuantite());
        return "redirect:/pv/create";
    }

    //Action quand on clique sur continuer
    @PostMapping("/savef")
    public String savefinal(ProduitVente pv)
    {
        pv.setVente(venteService.selectedVente(vid));
        service.save(pv);
        produitService.majQteProduitVente(pv.getProduit().getId(), pv.getQuantite());
        return "redirect:/pv/create";
    }

    @PostMapping("/saveft")
    public String saveft(ProduitVente pv)
    {
        pv.setVente(venteService.selectedVente(vid));
        venteService.montantVente(pv.getVente().getId());
        service.save(pv);
        produitService.majQteProduitVente(pv.getProduit().getId(), pv.getQuantite());
        return "redirect:/vente/show";
    }

    @PostMapping("/savet")
    public String saveterm(ProduitVente pv)
    {
        Vente vente = new Vente();
        vente.setDateVente(LocalDate.now());
        vente.setPrixTotal(venteService.montantVente(vente.getId()));
        venteService.saveVente(vente);

        vid = vente.getId();
        pv.setVente(vente);
        service.save(pv);
        produitService.majQteProduitVente(pv.getProduit().getId(), pv.getQuantite());
        return "redirect:/vente/show";
    }*/

}
