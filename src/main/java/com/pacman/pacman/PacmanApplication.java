package com.pacman.pacman;

import Classes.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class PacmanApplication {

	public static void main(String[] args) {SpringApplication.run(PacmanApplication.class, args);

		Point position = new Point(1, 2); // Définissez la position initiale de PacMan
		Direction direction = Direction.HAUT; // Spécifiez la direction initiale de PacMan
		int vies = 3; // Spécifiez le nombre de vies initial
		int vitesse = 2; // Spécifiez la vitesse initiale
		String couleur = "Jaune"; // Spécifiez la couleur initiale

		PacMan pacman = new PacMan(position, direction, vies, vitesse, couleur);

		@Scheduled(fixedRate = 1000) // La valeur en millisecondes
		public void executeTask() {
			// Placez ici la logique que vous souhaitez exécuter chaque seconde.
			System.out.println("coordPacman:"+pacman.getPosition().getPositionX() + " " +pacman.getPosition().getPositionY());
		}



	}






}
