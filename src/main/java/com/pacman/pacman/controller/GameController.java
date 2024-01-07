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
    @GetMapping("/test-deploiement-back")
    public String hello() {
        return "Déploiement du back a été réalisé avec succès !";
    }
    @PostMapping("/update-grid")
    public ResponseEntity<Game> updateGrid(@RequestBody DirectionWrapper direction) {
        Game currentGame = this.game;

        // Mettre à jour la grille avec la nouvelle direction
        System.out.println("direction "+direction);
        currentGame.updateGrid(direction.getDirection());

        return ResponseEntity.ok(currentGame);
    }



    //    @GetMapping("/play")
//    public String playGame(Model model) {
//        // Récupérer l'objet Game depuis la session
//        Game currentGame = (Game) model.getAttribute("game");
//        assert currentGame != null;
//        if (!currentGame.isStarted()) {
//            currentGame.demarrerJeu();
//            // Vous pouvez également effectuer d'autres initialisations si nécessaire
//        }
//
//        return "game/play";
//    }
//
//    @PostMapping("/update-grid")
//    public String updateGrid(@RequestParam("direction") int direction, Model model) {
//        // Récupérer l'objet Game depuis la session
//        Game currentGame = (Game) model.getAttribute("game");
//
//        // Mettre à jour la grille avec la direction
//        currentGame.updateGrid(direction);
//
//        // Vous pouvez renvoyer la vue avec les informations mises à jour
//
//        return "game/play";
//    }

//    @GetMapping("/current-game")
//    public ResponseEntity<Game> getCurrentGame() {
//        if (game == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//
//        return ResponseEntity.ok(game);
//    }
}
