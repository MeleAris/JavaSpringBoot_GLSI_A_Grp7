package com.glsi_a.tp1.controller;

import com.glsi_a.tp1.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
    @Autowired
    private ProduitService produitService;

    @GetMapping("/home")
    public String afficherBonjour(Model model) {
        model.addAttribute("nbStock", produitService.countProduit());
        model.addAttribute("nbRupture", produitService.countProduitRupture());
        return "Home";
    }
}