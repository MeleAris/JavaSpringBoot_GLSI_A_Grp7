package com.glsi_a.tp1.controller;

import com.glsi_a.tp1.service.ProduitService;
import com.glsi_a.tp1.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

        int an = LocalDate.now().getYear();
        int month = LocalDate.now().getMonthValue();
        int id;
        List<Integer> vente = venteService.stats(an);
        List<Integer> mois = venteService.mois(an);
        List<String> myList = Arrays.asList("Jan", "Fév", "Mars", "Avr", "Mai", "Juin", "Jui", "Août", "Sep", "Oct", "Nov", "Déc");
        List<String> map = new ArrayList<>();
        for (int i = 0; i <mois.stream().count(); i++)
        {
            id = mois.get(i);
            map.add(myList.get(id - 1));
        }
        model.addAttribute("annee", an);
        model.addAttribute("vente", vente);
        model.addAttribute("mois", map);
        model.addAttribute("nbStock", produitService.countProduit());
        model.addAttribute("nbRupture", produitService.countProduitRupture());
        model.addAttribute("nbvente", venteService.countVente(month));
        return "Home";
    }
    @GetMapping("/login")
    public String afficherLogin(){
        return "Login";
    }
}