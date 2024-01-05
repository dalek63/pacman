package com.pacman.pacman.controller;


// GameController.java
import Classes.Directiontest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PostMapping("/update-grid")
    public String updateGrid(@RequestBody Directiontest direction) {
        // Logique de mise à jour de la grille avec la nouvelle direction
        return "Grid mise à jour avec la direction : " + direction.getValue();
    }
}
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public Controller(@Lazy SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping("/pacman")
    public String hello() {
        return "Déploiement réalisé avec succès !";
    }

    @PostMapping("/update-list")
    public void updateList(@RequestBody List<String> updatedList) {
        // Mettez à jour la liste avec les données de updatedList

        // Envoyez la mise à jour à tous les clients connectés
        messagingTemplate.convertAndSend("/topic/list-update", updatedList);
    }
}

 */