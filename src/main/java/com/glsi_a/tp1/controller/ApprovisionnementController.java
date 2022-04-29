package com.glsi_a.tp1.controller;

import com.glsi_a.tp1.models.Approvisionnement;
import com.glsi_a.tp1.service.ApprovisionnementService;
import com.glsi_a.tp1.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/approvisionnement")
public class ApprovisionnementController {
    @Autowired
    private ProduitService produitService;

    @Autowired
    private ApprovisionnementService approvisionnementService;

    @GetMapping("/show")
    public String afficherApp(Model model) {
        model.addAttribute("listApp", approvisionnementService.showAllApprovisionnement());
        return "approvisionnement/showApprovisionnement";
    }
    @PostMapping("/filtre")
    public String dateApp(Filtre filtre ,Model model) {
        model.addAttribute("listApp", approvisionnementService.showAllFiltre(filtre.date1,filtre.date2));
        return "approvisionnement/showApprovisionnement";
    }

    @GetMapping("/create")
    public String afficherFormulaire(Model model) {
        model.addAttribute("listProduit", produitService.showAllProduit());
        return "approvisionnement/formApprovisionnement";
    }

    @PostMapping("/save")
    public String save(Approvisionnement approvisionnement) {
        approvisionnement.setDateApp(LocalDate.now());
        approvisionnementService.saveApprovisionnement(approvisionnement);
        produitService.majQteProduit(approvisionnement.getProduitId(), approvisionnement.getQuantite());
        return "redirect:/approvisionnement/show";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("unApp", approvisionnementService.selectedApprovisionnement(id));
        return "approvisionnement/formEditApprovisionnement";
    }

    @PostMapping("/edit")
    public String editApp(@ModelAttribute("unApp") Approvisionnement approvisionnement) {
        approvisionnementService.saveApprovisionnement(approvisionnement);
        return "redirect:/approvisionnement/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteApp(@PathVariable("id") int id) {
        approvisionnementService.deleteApprovisionnement(id);
        return "redirect:/approvisionnement/show";
    }

    @GetMapping("/showrupt")
    public String afficherProduitRupt(Model model) {
        model.addAttribute("listproduits", produitService.listRuptureProduit());
        return "approvisionnement/showRupture";
    }

    @GetMapping("/app/{id}")
    public String appProduit(@PathVariable("id") int id, Model model) {
        model.addAttribute("leProduit", produitService.selectedProduit(id));
        return "approvisionnement/formApprovisionnementProduit";
    }

    class Filtre {
        private LocalDate date1;
        private LocalDate date2;
    }
}
