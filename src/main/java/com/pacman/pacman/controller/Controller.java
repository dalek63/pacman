package com.pacman.pacman.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/pacman")
    public String hello() {
        return "Déploiement réalisé avec succès !";
    }
}