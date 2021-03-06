package com.glsi_a.tp1.controller;

import com.glsi_a.tp1.models.Produit;
import com.glsi_a.tp1.service.CategoryService;
import com.glsi_a.tp1.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/show")
    public String afficherProduit(Model model)
    {
        model.addAttribute("listProduit", produitService.showAllProduit());
        return "produit/showProduct";
    }

    @GetMapping("/create")
    public String afficherFormulaire(Model model)
    {
        model.addAttribute("listCategories", categoryService.showAllCategory());
        return "produit/formProduit";
    }

    @PostMapping("/save")
    public String save(Produit produit)
    {
        produit.setQteStock(0);
        produit.setDateCreation(LocalDate.now());
        produitService.saveProduit(produit);
        return "redirect:/produit/show";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("unProduit", produitService.selectedProduit(id));
        return "produit/formEditProduit";
    }

    @PostMapping("/edit")
    public String editProduit(@ModelAttribute("unProduit") Produit produit)
    {
        produitService.saveProduit(produit);
        return "redirect:/produit/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduit(@PathVariable("id") int id)
    {
        produitService.deleteProduit(id);
        return "redirect:/produit/show";
    }
}
