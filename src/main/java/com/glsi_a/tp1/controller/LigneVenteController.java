package com.glsi_a.tp1.controller;

import com.glsi_a.tp1.models.LigneVente;
import com.glsi_a.tp1.service.LigneVenteService;
import com.glsi_a.tp1.service.ProduitService;
import com.glsi_a.tp1.service.LigneVenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/ligneVente")
public class LigneVenteController {
    @Autowired
    private ProduitService produitService;

    @Autowired
    private LigneVenteService ligneVenteService;

    @GetMapping("/show")
    public String afficherLigneVente(Model model)
    {
        model.addAttribute("listligneVente", ligneVenteService.showAllLigneVente());
        return "ligneVente/showLigneVente";
    }

    @GetMapping("/create")
    public String afficherFormulaire(Model model)
    {
        model.addAttribute("listProduit", produitService.showAllProduit());
        return "ligneVente/formLigneVente";
    }

    @PostMapping("/save")
    public String saveLigneVente(LigneVente ligneVente)
    {

        ligneVenteService.saveLigneVente(ligneVente);
        produitService.majQteProduit(ligneVente.getProduitId(), ligneVente.getQuantite());
        return "redirect:/ligneVente/show";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("uneLigneVente", ligneVenteService.selectedLigneVente(id));
        return "ligneVente/formEditLigneVente";
    }

    @PostMapping("/edit")
    public String editLigneVente(@ModelAttribute("uneVente") LigneVente LigneVente)
    {
        ligneVenteService.saveLigneVente(LigneVente);
        return "redirect:/ligneVente/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteLigneVente(@PathVariable("id") int id)
    {
        ligneVenteService.deleteLigneVente(id);
        return "redirect:/ligneVente/show";
    }
}


