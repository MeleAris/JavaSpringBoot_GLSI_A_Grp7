package com.glsi_a.tp1.controller;

import com.glsi_a.tp1.models.Vente;
import com.glsi_a.tp1.service.VenteService;
import com.glsi_a.tp1.service.ProduitService;
import com.glsi_a.tp1.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/vente")
public class VenteController {
    @Autowired
    private ProduitService produitService;

    @Autowired
    private VenteService venteService;

    @GetMapping("/show")
    public String afficherVente(Model model)
    {
        model.addAttribute("listVente", venteService.showAllVente());
        return "vente/showVente";
    }

    @GetMapping("/create")
    public String afficherFormulaire(Model model)
    {
        model.addAttribute("listProduit", produitService.showAllProduit());
        return "vente/formVente";
    }

    @PostMapping("/save")
    public String save(Vente vente)
    {
        vente.setDateVente(LocalDate.now());
        venteService.saveVente(vente);

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
}

