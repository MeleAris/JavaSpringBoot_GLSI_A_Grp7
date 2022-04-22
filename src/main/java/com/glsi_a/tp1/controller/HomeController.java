package com.glsi_a.tp1.controller;

import com.glsi_a.tp1.service.ProduitService;
import com.glsi_a.tp1.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    @Autowired
    private ProduitService produitService;

    @Autowired
    private VenteService venteService;

    @GetMapping("/home")
    public String afficherBonjour(Model model) {

        List<Double> vente = venteService.showAllVente().stream().map(x-> x.getPrixTotal()).collect(Collectors.toList());

        model.addAttribute("vente", vente);
        model.addAttribute("nbStock", produitService.countProduit());
        model.addAttribute("nbRupture", produitService.countProduitRupture());
        model.addAttribute("nbvente", venteService.countVente());
        return "Home";
    }
}