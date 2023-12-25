package com.pacman.pacman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Classes.Terrain;
import Classes.TypeCellule;

@SpringBootApplication
public class PacmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(PacmanApplication.class, args);

        // Code de test pour le Terrain
        testTerrain();
    }

    private static void testTerrain() {
        int tailleGrille = 15; // Taille de la grille (15x15)
        Terrain terrain = new Terrain(tailleGrille, 15); // Crée une grille de 15 lignes et 15 colonnes

        initialiserGrille(terrain); // Initialise la grille avec les murs et les espaces vides

        System.out.println("Grille avec des murs :");
        for (int i = 0; i < tailleGrille; i++) {
            for (int j = 0; j < 15; j++) { // Utilisation d'une taille fixe de colonnes (15)
                int valeurCellule = terrain.obtenirValeurCellule(i, j);
                if (valeurCellule == TypeCellule.MUR.ordinal()) {
                    System.out.print("M "); // Affiche un mur
                } else if (valeurCellule == TypeCellule.POINT.ordinal()) {
                    System.out.print("P "); // Affiche le point de départ de Pac-Man
                } else {
                    System.out.print(". "); // Affiche un espace vide
                }
            }
            System.out.println(); // Nouvelle ligne pour chaque ligne de la grille
        }
    }



    private static void initialiserGrille(Terrain terrain) {
        char[][] grille = {
                {'P', '.', '.', '.', 'M', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'M', '.', '.', '.', 'M', 'M', '.', '.', 'M', '.', '.'},
                {'.', 'M', 'M', '.', 'M', 'M', '.', 'M', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'M', '.', '.', 'M', '.', 'M', '.', '.', '.', 'M', 'M', 'M', '.'},
                {'.', '.', '.', '.', '.', '.', '.', 'M', 'M', 'M', '.', '.', '.', '.', '.'},
                {'.', '.', 'M', '.', '.', 'M', '.', '.', 'M', '.', '.', 'M', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', 'M', '.', 'M', 'M', '.', '.'},
                {'M', 'M', 'M', '.', 'M', '.', 'M', '-', 'M', '.', 'M', '.', '.', '.', '.'},
                {'.', '.', 'M', '.', 'M', '.', 'M', '.', 'M', '.', 'M', '.', '.', '.', '.'},
                {'M', 'M', 'M', '.', '.', '.', 'M', 'M', 'M', '.', '.', '.', 'M', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', 'M', '.', '.', '.', 'M', '.', '.'},
                {'M', 'M', 'M', 'M', 'M', 'M', 'M', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'M', '.', '.', '.', '.', '.', 'M', '.', '.', 'M', '.', '.'},
                {'.', '.', '.', 'M', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', 'M', 'M', 'M', '.', '.', '.', '.', '.', '.', '.'}
        };

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                if (grille[i][j] == 'P') {
                    terrain.modifierValeurCellule(i, j, TypeCellule.POINT.ordinal());
                } else if (grille[i][j] == 'M') {
                    terrain.modifierValeurCellule(i, j, TypeCellule.MUR.ordinal());
                }
                // Ajoutez des conditions supplémentaires si nécessaire pour d'autres caractères
            }
        }
    }

}
