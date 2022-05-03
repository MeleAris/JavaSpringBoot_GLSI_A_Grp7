package com.glsi_a.tp1.controller;

import com.glsi_a.tp1.models.*;
import com.glsi_a.tp1.service.ProduitVenteService;
import com.glsi_a.tp1.service.VenteService;
import com.glsi_a.tp1.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/vente")
public class VenteController {

    private int vid;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private VenteService venteService;
    @Autowired
    private ProduitVenteService service;

    @GetMapping("/show")
    public String afficherVente(Model model)
    {
        model.addAttribute("listVente", venteService.showAllVente());
        model.addAttribute("list", service.showAll());
        return "vente/showVente";
    }

    @GetMapping("/create")
    public String afficherFormulaire(Model model)
    {
        model.addAttribute("listProduit", produitService.listProduit());
        return "vente/formVente";
    }

    @GetMapping("/created")
    public String affFormulaire(Model model)
    {
        model.addAttribute("listProduit", produitService.listProduit());
        return "vente/formVenteContinuer";
    }

    //Action quand on va cliquer la première fois sur continuer >>
    @PostMapping("/save")
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
        return "redirect:/vente/created";
    }

    //Action quand on clique sur continuer apres le first continuer
    @PostMapping("/savef")
    public String savefinal(ProduitVente pv)
    {
        pv.setVente(venteService.selectedVente(vid));
        venteService.majmontantVente(pv.getVente().getId());
        service.save(pv);
        produitService.majQteProduitVente(pv.getProduit().getId(), pv.getQuantite());
        return "redirect:/vente/created";
    }

    //Clique sur terminer apres continuer
    @GetMapping("/saveft/{id}/{qte}")
    public String saveft(@PathVariable("id") int id, @PathVariable("qte") int qte)
    {
        ProduitVente pv = new ProduitVente();
        pv.setProduit(produitService.selectedProduit(id));
        pv.setQuantite(qte);

        pv.setVente(venteService.selectedVente(vid));
        venteService.majmontantVente(pv.getVente().getId());
        service.save(pv);
        produitService.majQteProduitVente(pv.getProduit().getId(), pv.getQuantite());
        return "redirect:/vente/show";
    }

    //Clique direct sur terminer
    @GetMapping("/savet/{id}")
    public String saveterm(@PathVariable int id, @ModelAttribute form f)
    {
        ProduitVente pv = new ProduitVente();
        pv.setProduit(produitService.selectedProduit(id + 1));
        pv.setQuantite(f.getQuantite());

        Vente vente = new Vente();
        vente.setDateVente(LocalDate.now());
        vente.setPrixTotal(venteService.montantVente(vente.getId()));
        venteService.saveVente(vente);

        pv.setVente(vente);
        service.save(pv);
        produitService.majQteProduitVente(pv.getProduit().getId(), pv.getQuantite());
        return "redirect:/vente/show";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("uneVente", venteService.selectedVente(id));
        return "vente/formEditVente";
    }

    @PostMapping("/edit")
    public String editVente(@ModelAttribute("uneVente") Vente vente)
    {
        venteService.saveVente(vente);
        return "redirect:/vente/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteVente(@PathVariable("id") int id)
    {
        venteService.deleteVente(id);
        return "redirect:/vente/show";
    }

    @PostMapping("/saves")
    public String saves(ProduitVente pv, @ModelAttribute("vendre") ProduitVente p)
    {
        /*Vente ventes = new Vente();
        ventes.setDateVente(LocalDate.now());
        ventes.setPrixTotal(0);
        venteService.saveVente(ventes);

        vid = ventes.getId();
        pv.setVente(ventes);
        service.save(pv);
        produitService.majQteProduitVente(pv.getProduit().getId(), pv.getQuantite());*/

        Vente v = new Vente();
        v.setDateVente(LocalDate.now());
        //Calcul du prix total

        pv.setVente(v);
        venteService.saveVente(v);

        return "redirect:/vente/created";
    }

    @GetMapping("/stat1")
    public String statistiques(Model model, @ModelAttribute dateform d)
    {
        model.addAttribute("list", venteService.statVente(d.getDate1(), d.getDate2()));
        model.addAttribute("prd", service.showAll());
        return "vente/affDate";
    }

    @PostMapping("/stat12")
    public String statistique(@ModelAttribute("dates") dateform d)
    {
        return "vente/showVente";
    }

}

