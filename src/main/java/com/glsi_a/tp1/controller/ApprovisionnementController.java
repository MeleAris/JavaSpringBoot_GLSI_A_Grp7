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
    public String afficherApp(Model model)
    {
        model.addAttribute("listApp", approvisionnementService.showAllApprovisionnement());
        return "approvisionnement/showApprovisionnement";
    }

    @GetMapping("/create")
    public String afficherFormulaire(Model model)
    {
        model.addAttribute("listProduit", produitService.showAllProduit());
        return "approvisionnement/formApprovisionnement";
    }

    @PostMapping("/save")
    public String save(Approvisionnement approvisionnement)
    {
        approvisionnement.setDateApp(LocalDate.now());
        approvisionnementService.saveApprovisionnement(approvisionnement);
        return "redirect:/approvisionnement/show";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("unApp", approvisionnementService.selectedApprovisionnement(id));
        return "approvisionnement/formEditApprovisionnement";
    }

    @PostMapping("/edit")
    public String editApp(@ModelAttribute("unApp") Approvisionnement approvisionnement)
    {
        approvisionnementService.saveApprovisionnement(approvisionnement);
        return "redirect:/approvisionnement/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteApp(@PathVariable("id") int id)
    {
        approvisionnementService.deleteApprovisionnement(id);
        return "redirect:/approvisionnement/show";
    }
}
