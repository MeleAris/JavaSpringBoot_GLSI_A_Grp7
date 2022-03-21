package com.glsi_a.tp1.controller;

import com.glsi_a.tp1.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProduitController {
    @Autowired
    private ProduitService produitService;
}
