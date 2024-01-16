package com.pacman.pacman.controller;
import Classes.DirectionWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import Classes.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/game")
@RestController
@SessionAttributes("game")
@CrossOrigin
public class GameController {

    private final Game game;

    @Autowired
    public GameController(Game game) {
        this.game = game;
    }


    @PostMapping("/start-game")
    public ResponseEntity<Game> startGame() {
        Game currentGame = this.game;

        // Vérifier si le jeu a déjà démarré
        if (!currentGame.isStarted()) {
            // Démarrer le jeu si ce n'est pas déjà fait
            currentGame.demarrerJeu();
        }

        return ResponseEntity.ok(currentGame);
    }
    //Pour charger la Map avant de lancer le jeu
    @PostMapping("/load-map")
    public ResponseEntity<Game> loadMap() {
        Game currentGame = this.game;
        currentGame.initialiserJeu();
        return ResponseEntity.ok(currentGame);
    }

    @GetMapping("/test-deploiement-back")
    public String hello() {
        return "Déploiement du back a été réalisé avec succès !";
    }

//    @PostMapping("/update-grid")
//    public ResponseEntity<Game> updateGridFantome(@RequestBody String directionData) {
//        Game currentGame = this.game;
//
//        DirectionWrapper directionConverter = new DirectionWrapper(directionData);
//
//        System.out.println("FRONT : Direction recu = "+directionData);
//        // Mettre à jour la grille avec la nouvelle direction
//        currentGame.updateGrid(directionConverter.getDirection());
//        System.out.println("direction recu convertit "+directionConverter.getDirection());
//        return ResponseEntity.ok(currentGame);
//    }
    @CrossOrigin
    @PostMapping("/update-grid-fantome")
    public ResponseEntity<Game> updateGridFantome() {
        Game currentGame = this.game;

        System.out.println("UPADATE FANTOME");
        // Mettre à jour la grille avec la nouvelle direction
        currentGame.updateFantomes();
        return ResponseEntity.ok(currentGame);
    }

    @CrossOrigin
    @PostMapping("/update-grid-pacman")
    public ResponseEntity<Game> updateGridPacman(@RequestBody String directionData) {
        Game currentGame = this.game;
        System.out.println("UPADATE PACMAN");
        DirectionWrapper directionConverter = new DirectionWrapper(directionData);

        System.out.println("FRONT : Direction recu = "+directionData);
        // Mettre à jour la grille avec la nouvelle direction
        currentGame.updateGridPacman(directionConverter.getDirection());
        System.out.println("direction recu convertit "+directionConverter.getDirection());
        return ResponseEntity.ok(currentGame);
    }

}
